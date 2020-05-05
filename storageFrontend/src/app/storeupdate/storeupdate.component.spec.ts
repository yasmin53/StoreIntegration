import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreupdateComponent } from './storeupdate.component';

describe('StoreupdateComponent', () => {
  let component: StoreupdateComponent;
  let fixture: ComponentFixture<StoreupdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoreupdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
