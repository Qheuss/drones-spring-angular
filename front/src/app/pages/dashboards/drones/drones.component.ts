import { AddDroneComponent } from '@/components/add-drone/add-drone.component';
import { UpdateDrone } from '@/components/update-drone/update-drone';
import { IDrone } from '@/models/IDrone';
import { DroneService } from '@/services/drone.service';
import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { AsyncPipe } from '@angular/common';
import { RemoveDrone } from '@/components/remove-drone/remove-drone';
import { Trash } from '@/components/trash/trash';
import { BehaviorSubject, map, shareReplay, switchMap } from 'rxjs';

@Component({
    selector: 'app-drones',
    imports: [TableModule, AddDroneComponent, UpdateDrone, AsyncPipe, RemoveDrone, Trash],
    templateUrl: './drones.component.html',
    styleUrl: './drones.component.scss'
})
export class DronesComponent {
    private droneService = inject(DroneService);
    private refreshDrones$ = new BehaviorSubject<void>(void 0);

    drones$ = this.refreshDrones$.pipe(
        switchMap(() => this.droneService.getAll()),
        shareReplay({ bufferSize: 1, refCount: true })
    );

    nonDeletedDrones$ = this.drones$.pipe(map((drones) => drones.filter((drone) => !drone.isDeleted)));

    deletedDrones$ = this.drones$.pipe(map((drones) => drones.filter((drone) => drone.isDeleted)));

    onDroneRemoved(): void {
        this.refreshDrones$.next();
    }

    onDroneUpdated(): void {
        this.refreshDrones$.next();
    }

    onDroneAdded(): void {
        this.refreshDrones$.next();
    }

    onDroneRestored(drone: IDrone): void {
        this.droneService.updateById(drone.id, drone).subscribe({
            next: () => this.refreshDrones$.next(),
            error: (error) => {
                console.error('Unable to restore drone:', error);
            }
        });
    }
}
