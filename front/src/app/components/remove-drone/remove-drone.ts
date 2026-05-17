import { DroneService } from '@/services/drone.service';
import { Component, inject, input, output } from '@angular/core';
import { ButtonModule } from 'primeng/button';

@Component({
    selector: 'app-remove-drone',
    imports: [ButtonModule],
    templateUrl: './remove-drone.html',
    styleUrl: './remove-drone.scss'
})
export class RemoveDrone {
    private droneService = inject(DroneService);
    droneId = input<number>();
    droneRemoved = output<number>();

    removeDrone(id: number): void {
        this.droneService.deleteById(id).subscribe({
            next: () => {
                console.log('Drone removed successfully');
                this.droneRemoved.emit(id);
            },
            error: (error) => {
                console.error('Unable to remove drone:', error);
            }
        });
    }
}
