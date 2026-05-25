import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IDrone } from '../models/IDrone';

@Injectable({
    providedIn: 'root'
})
export class DroneService {
    private apiUrl = 'http://localhost:8080/api/drones';

    constructor(private http: HttpClient) {}

    getAll(): Observable<IDrone[]> {
        return this.http.get<IDrone[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<IDrone | null> {
        return this.http.get<IDrone | null>(`${this.apiUrl}/${id}`);
    }

    addDrone(drone: IDrone): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, drone);
    }

    updateById(id: number, drone: IDrone): Observable<void> {
        return this.http.put<void>(`${this.apiUrl}/${id}`, drone);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
