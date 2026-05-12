import { IDrone } from '@/models/IDrone';
import { DroneService } from '@/services/drone.service';
import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';

@Component({
    selector: 'app-drones',
    imports: [TableModule],
    templateUrl: './drones.component.html',
    styleUrl: './drones.component.scss'
})
export class DronesComponent {
    private droneService = inject(DroneService);

    drones: IDrone[] = [];

    ngOnInit(): void {
        this.droneService.getAll().subscribe({
            next: (data) => {
                this.drones = data;
            },
            error: () => {
                console.error('Unable to load drones from the API.');
            }
        });
    }
}
