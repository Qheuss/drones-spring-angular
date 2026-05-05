import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { IFlightController } from '@/models/IFlightController';
import { FlightControllerService } from '@/services/flight-controller.service';

@Component({
    selector: 'app-flight-controllers',
    imports: [TableModule],
    templateUrl: './flight-controllers.component.html',
    styleUrl: './flight-controllers.component.scss'
})
export class FlightControllersComponent {
    private flightControllerService = inject(FlightControllerService);

    flightControllers: IFlightController[] = [];

    ngOnInit(): void {
        this.flightControllerService.getAll().subscribe((data) => {
            this.flightControllers = data;
        });
    }
}
