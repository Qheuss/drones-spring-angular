import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IFrame } from '../models/IFrame';

@Injectable({
    providedIn: 'root'
})
export class FrameService {
    private apiUrl = 'http://localhost:8080/api/frames';

    constructor(private http: HttpClient) {}

    getAll(): Observable<IFrame[]> {
        return this.http.get<IFrame[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<IFrame> {
        return this.http.get<IFrame>(`${this.apiUrl}/${id}`);
    }

    addFrame(frame: IFrame): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, frame);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
