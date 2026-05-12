import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IFlightController } from '../models/IFlightController';

@Injectable({
    providedIn: 'root'
})
export class FlightControllerService {
    private apiUrl = 'http://localhost:8080/api/flight-controllers';

    constructor(private http: HttpClient) {}

    getAll(): Observable<IFlightController[]> {
        return this.http.get<IFlightController[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<IFlightController | null> {
        return this.http.get<IFlightController | null>(`${this.apiUrl}/${id}`);
    }

    addFlightController(flightController: IFlightController): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, flightController);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
