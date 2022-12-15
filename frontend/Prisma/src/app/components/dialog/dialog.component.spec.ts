import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DialogData } from './dialog.component';

import { DialogComponent } from './dialog.component';

describe('CancelDialogComponent', () => {
  let fixture: ComponentFixture<DialogComponent>;
  let mockDialogRef: jasmine.SpyObj<any>;
  let mockRouter: jasmine.SpyObj<any>;

  let instance: any;

let onYesClickTestFunction = (router: jasmine.SpyObj<any>) => {
  router.navigate(['/home']);
}

  const data: DialogData = {
    title: 'Title',
    content: 'Content',
    onNoClickButtonTitle: 'onNoClickTitle',
    onYesClickButtonTitle: 'onYesClickTitle',
    onYesClickFunction: onYesClickTestFunction
  }

  beforeEach(async () => {
    mockDialogRef = jasmine.createSpyObj('MatDialogRef',['close']);
    mockRouter = jasmine.createSpyObj(['navigate']);
    await TestBed.configureTestingModule({
      declarations: [ DialogComponent ],
      imports: [
        MatDialogModule
      ],
      providers: [
        { provide: MatDialogRef<DialogComponent>, useValue: mockDialogRef},
        { provide: Router, useValue: mockRouter},
        { provide: MAT_DIALOG_DATA, useValue: data}
      ]
    });

    fixture = TestBed.createComponent(DialogComponent);
    instance = fixture.debugElement.componentInstance;
    fixture.detectChanges();
  });

  describe('onNoClick', () => {
    it('should call close on dialogRef', () => {
      instance.onNoClick();
      expect(mockDialogRef.close).toHaveBeenCalled();
    });
  });

  describe('onYesClick', () => {
    it('should call close on dialogRef', () => {
      instance.onYesClick();
      expect(mockDialogRef.close).toHaveBeenCalled();
    });

    it('it should call onYesClickFunction of data', () => {
      spyOn(instance.data, 'onYesClickFunction').and.callThrough();
      instance.onYesClick();
      expect(instance.data.onYesClickFunction).toHaveBeenCalledWith(mockRouter);
    })
  })


});
