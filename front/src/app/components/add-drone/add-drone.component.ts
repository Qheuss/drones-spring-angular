import { AsyncPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputTextModule } from 'primeng/inputtext';
import { SelectModule } from 'primeng/select';
import { BatteryService } from '@/services/battery.service';
import { CameraService } from '@/services/camera.service';
import { FlightControllerService } from '@/services/flight-controller.service';
import { FrameService } from '@/services/frame.service';
import { MotorService } from '@/services/motor.service';
import { PropService } from '@/services/prop.service';
import { IDrone } from '@/models/IDrone';
import { VideoLinkType } from '@/models/enums/VideoLinkType';
import { AccordionModule } from 'primeng/accordion';
import { DroneService } from '@/services/drone.service';

@Component({
    selector: 'app-add-drone',
    standalone: true,
    imports: [AsyncPipe, ButtonModule, SelectModule, InputGroupModule, InputGroupAddonModule, InputNumberModule, InputTextModule, FormsModule, AccordionModule],
    templateUrl: './add-drone.component.html',
    styleUrl: './add-drone.component.scss'
})
export class AddDroneComponent {
    private droneService = inject(DroneService);
    private propService = inject(PropService);
    private motorService = inject(MotorService);
    private flightControllerService = inject(FlightControllerService);
    private cameraService = inject(CameraService);
    private frameService = inject(FrameService);
    private batteryService = inject(BatteryService);

    drone: IDrone = {
        id: 0,
        name: '',
        prop: null,
        motor: null,
        flightController: null,
        camera: null,
        frame: null,
        battery: null,
        videoLinkType: VideoLinkType.DIGITAL,
        propsCount: 4
    };

    propOptions$ = this.propService.getAll();
    motorOptions$ = this.motorService.getAll();
    flightControllerOptions$ = this.flightControllerService.getAll();
    cameraOptions$ = this.cameraService.getAll();
    frameOptions$ = this.frameService.getAll();
    batteryOptions$ = this.batteryService.getAll();

    videoLinkTypes = Object.values(VideoLinkType);

    submitDrone(): void {
        this.droneService.addDrone(this.drone).subscribe({
            next: () => {
                console.log('Drone added successfully: ', this.drone);
            },
            error: (error) => {
                console.error('Unable to add drone to the API.', error);
            }
        });
    }
}
