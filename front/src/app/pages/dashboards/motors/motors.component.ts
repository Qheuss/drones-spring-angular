import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { IMotor } from '@/models/IMotor';
import { MotorService } from '@/services/motor.service';

@Component({
    selector: 'app-motors',
    imports: [TableModule],
    templateUrl: './motors.component.html',
    styleUrl: './motors.component.scss'
})
export class MotorsComponent {
    private motorService = inject(MotorService);

    motors: IMotor[] = [];

    ngOnInit(): void {
        this.motorService.getAll().subscribe((data) => {
            this.motors = data;
        });
    }
}
