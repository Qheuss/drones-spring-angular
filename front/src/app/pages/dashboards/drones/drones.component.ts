import { AddDroneComponent } from '@/components/add-drone/add-drone.component';
import { UpdateDrone } from '@/components/update-drone/update-drone';
import { DroneService } from '@/services/drone.service';
import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { AsyncPipe } from '@angular/common';
import { RemoveDrone } from '@/components/remove-drone/remove-drone';

@Component({
    selector: 'app-drones',
    imports: [TableModule, AddDroneComponent, UpdateDrone, AsyncPipe, RemoveDrone],
    templateUrl: './drones.component.html',
    styleUrl: './drones.component.scss'
})
export class DronesComponent {
    private droneService = inject(DroneService);

    drones$ = this.droneService.getAll();

    onDroneRemoved(): void {
        this.drones$ = this.droneService.getAll();
    }

    onDroneUpdated(): void {
        this.drones$ = this.droneService.getAll();
    }

    onDroneAdded(): void {
        this.drones$ = this.droneService.getAll();
    }
}
