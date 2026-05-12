import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IBattery } from '../models/IBattery';

@Injectable({
    providedIn: 'root'
})
export class BatteryService {
    private apiUrl = 'http://localhost:8080/api/batteries';

    constructor(private http: HttpClient) {}

    getAll(): Observable<IBattery[]> {
        return this.http.get<IBattery[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<IBattery | null> {
        return this.http.get<IBattery | null>(`${this.apiUrl}/${id}`);
    }

    addBattery(battery: IBattery): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, battery);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
