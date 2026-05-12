import { IBattery } from './IBattery';
import { ICamera } from './ICamera';
import { IFlightController } from './IFlightController';
import { IFrame } from './IFrame';
import { IMotor } from './IMotor';
import { IProp } from './IProp';
import { VideoLinkType } from './enums/VideoLinkType';

export interface IDrone {
    id: number;
    name: string;
    prop: IProp | null;
    motor: IMotor | null;
    flightController: IFlightController | null;
    camera: ICamera | null;
    frame: IFrame | null;
    battery: IBattery | null;
    videoLinkType: VideoLinkType;
    propsCount: number;
    weightGrams?: number;
    wheelbaseMm?: number;
    flightTimeMinutes?: number;
}
