import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICamera } from '../models/ICamera';

@Injectable({
    providedIn: 'root'
})
export class CameraService {
    private apiUrl = 'http://localhost:8080/api/cameras';

    constructor(private http: HttpClient) {}

    getAll(): Observable<ICamera[]> {
        return this.http.get<ICamera[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<ICamera | null> {
        return this.http.get<ICamera | null>(`${this.apiUrl}/${id}`);
    }

    addCamera(camera: ICamera): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, camera);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
