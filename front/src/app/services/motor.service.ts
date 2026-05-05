import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IMotor } from '../models/IMotor';

@Injectable({
    providedIn: 'root'
})
export class MotorService {
    private apiUrl = 'http://localhost:8080/api/motors';

    constructor(private http: HttpClient) {}

    getAll(): Observable<IMotor[]> {
        return this.http.get<IMotor[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<IMotor> {
        return this.http.get<IMotor>(`${this.apiUrl}/${id}`);
    }

    addMotor(motor: IMotor): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, motor);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
