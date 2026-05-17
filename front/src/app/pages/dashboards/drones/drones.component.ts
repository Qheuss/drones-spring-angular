import { AddDroneComponent } from '@/components/add-drone/add-drone.component';
import { IDrone } from '@/models/IDrone';
import { DroneService } from '@/services/drone.service';
import { Component, inject, signal } from '@angular/core';
import { TableModule } from 'primeng/table';
import { AsyncPipe } from '@angular/common';
import { RemoveDrone } from '@/components/remove-drone/remove-drone';

@Component({
    selector: 'app-drones',
    imports: [TableModule, AddDroneComponent, AsyncPipe, RemoveDrone],
    templateUrl: './drones.component.html',
    styleUrl: './drones.component.scss'
})
export class DronesComponent {
    private droneService = inject(DroneService);

    drones$ = this.droneService.getAll();

    onDroneRemoved(): void {
        this.drones$ = this.droneService.getAll();
    }
}
