import {Department} from '../../department/main-department/department';
export class Employee {

  private _id: number;
  private _name: string;
  private _active: boolean;
  private _department: Department = new Department();

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get active(): boolean {
    return this._active;
  }

  set active(value: boolean) {
    this._active = value;
  }

  get department(): Department {
    return this._department;
  }

  set department(value: Department) {
    this._department = value;
  }
}
