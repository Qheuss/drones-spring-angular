import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProp } from '../models/IProp';

@Injectable({
    providedIn: 'root'
})
export class PropService {
    private apiUrl = 'http://localhost:8080/api/props';

    constructor(private http: HttpClient) {}

    getAll(): Observable<IProp[]> {
        return this.http.get<IProp[]>(`${this.apiUrl}/all`);
    }

    getById(id: number): Observable<IProp | null> {
        return this.http.get<IProp | null>(`${this.apiUrl}/${id}`);
    }

    addProp(prop: IProp): Observable<void> {
        return this.http.post<void>(`${this.apiUrl}/new`, prop);
    }

    deleteById(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
