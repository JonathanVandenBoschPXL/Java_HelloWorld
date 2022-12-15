import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(
        private toastrService: ToastrService
    ) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(req).pipe(
            catchError((err) => {
                if (err.status === 400) {
                    this.toastrService.warning('Error code 400: Bad request.', 'Something went wrong!', {positionClass: 'toast-bottom-right'});
                } else if (err.status === 404) {
                    this.toastrService.warning('Error code 404: Not found. We could not find the requested resource:' + err.message, 'Something wasn\'t found', {positionClass: 'toast-bottom-right'})
                } else {
                    this.toastrService.error('Error: ' + err.message, 'Something went wrong', {
                        disableTimeOut: true,
                        closeButton: true,
                        tapToDismiss: false,
                        positionClass: 'toast-bottom-right'
                });
                }
                return throwError(() => new Error(err));
            })
        );
    }
}