-- Seed script: base data plus Air75 II variants
-- Entities: motors, flight_controllers, cameras, frames, batteries, props, drones

INSERT INTO motors (model, kv_rating) VALUES ('T-Motor F60 Pro', '1950KV');
INSERT INTO motors (model, kv_rating) VALUES ('EMAX ECO II 2207', '1700KV');
INSERT INTO motors (model, kv_rating) VALUES ('BrotherHobby Avenger 2306', '1750KV');
INSERT INTO motors (model, kv_rating) VALUES ('iFlight XING2 2207', '1960KV');
INSERT INTO motors (model, kv_rating) VALUES ('SpeedX2 1404', '2800KV');
INSERT INTO motors (model, kv_rating) VALUES ('RCINPOWER GTS V3', '1650KV');
INSERT INTO motors (model, kv_rating) VALUES ('GEPRC SPEEDX2 1505', '3000KV');
INSERT INTO motors (model, kv_rating) VALUES ('T-Motor F80', '1150KV');
INSERT INTO motors (model, kv_rating) VALUES ('SunnySky X4108', '380KV');
INSERT INTO motors (model, kv_rating) VALUES ('KDE 7215XF', '320KV');

INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Matek H743', 16, 'ELRS', 'RTH');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Betaflight F4', 8, 'CROSSFIRE', 'ACRO');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('SpeedyBee F7', 12, 'ELRS', 'ANGLE');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Holybro Kakute H7', 14, 'FRSKY', 'HORIZON');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('iFlight SucceX E', 10, 'ELRS', 'SELF_LEVEL');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Mamba F405', 8, 'SBUS', 'ACRO');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Kiss FC', 12, 'ELRS', 'HOVER');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Cube Orange+', 18, 'IBUS', 'RTH');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Durandal', 20, 'DSMX', 'HOVER');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Pixhawk 6X', 24, 'ELRS', 'RTH');

INSERT INTO cameras (model, resolution_mp) VALUES ('RunCam Phoenix 2', 2);
INSERT INTO cameras (model, resolution_mp) VALUES ('Foxeer Predator', 2);
INSERT INTO cameras (model, resolution_mp) VALUES ('GoPro Hero 12', 27);
INSERT INTO cameras (model, resolution_mp) VALUES ('DJI O3 Air Unit', 12);
INSERT INTO cameras (model, resolution_mp) VALUES ('Caddx Polar', 4);
INSERT INTO cameras (model, resolution_mp) VALUES ('RunCam Thumb Pro', 12);
INSERT INTO cameras (model, resolution_mp) VALUES ('Insta360 GO 3', 9);
INSERT INTO cameras (model, resolution_mp) VALUES ('Autel EVO Cam', 48);
INSERT INTO cameras (model, resolution_mp) VALUES ('Sony RX0 II', 15);
INSERT INTO cameras (model, resolution_mp) VALUES ('Blackmagic Micro', 13);

INSERT INTO frames (model, material) VALUES ('250 Carbon X', 'Carbon Fiber');
INSERT INTO frames (model, material) VALUES ('350 Racing Frame', 'Carbon Fiber');
INSERT INTO frames (model, material) VALUES ('450 Long Range', 'Aluminum');
INSERT INTO frames (model, material) VALUES ('7-inch Explorer', 'Carbon Fiber');
INSERT INTO frames (model, material) VALUES ('Cinewhoop Lite', 'Composite');
INSERT INTO frames (model, material) VALUES ('Micro Quad 65', 'Polymer');
INSERT INTO frames (model, material) VALUES ('Hexa Cargo', 'Aluminum');
INSERT INTO frames (model, material) VALUES ('VTOL Scout', 'Carbon Fiber');
INSERT INTO frames (model, material) VALUES ('Agriculture X8', 'Aluminum');
INSERT INTO frames (model, material) VALUES ('Heavy Lift Pro', 'Carbon Fiber');

INSERT INTO batteries (model, capacity_mah) VALUES ('4S 1300mAh', 1300);
INSERT INTO batteries (model, capacity_mah) VALUES ('4S 1500mAh', 1500);
INSERT INTO batteries (model, capacity_mah) VALUES ('6S 1500mAh', 1500);
INSERT INTO batteries (model, capacity_mah) VALUES ('6S 2200mAh', 2200);
INSERT INTO batteries (model, capacity_mah) VALUES ('6S 3000mAh', 3000);
INSERT INTO batteries (model, capacity_mah) VALUES ('2S 450mAh', 450);
INSERT INTO batteries (model, capacity_mah) VALUES ('3S 850mAh', 850);
INSERT INTO batteries (model, capacity_mah) VALUES ('8S 5000mAh', 5000);
INSERT INTO batteries (model, capacity_mah) VALUES ('6S 4000mAh', 4000);
INSERT INTO batteries (model, capacity_mah) VALUES ('12S 10000mAh', 10000);

INSERT INTO props (model, spec) VALUES ('Gemfan 1614 3-Blade Propellers', '1.0mm Shaft');
INSERT INTO props (model, spec) VALUES ('GF 1614 3-B Props', '1.0mm Shaft');
INSERT INTO props (model, spec) VALUES ('GF 1614 3B Props', '1.0mm Shaft');
INSERT INTO props (model, spec) VALUES ('Gemfan 51466', '3.5mm Shaft');
INSERT INTO props (model, spec) VALUES ('HQProp 5x4x3', '5mm Shaft');
INSERT INTO props (model, spec) VALUES ('Dalprop 5x4.3x3', '5mm Shaft');
INSERT INTO props (model, spec) VALUES ('Gemfan 7035', '6mm Shaft');
INSERT INTO props (model, spec) VALUES ('HQProp T5X4', '5mm Shaft');
INSERT INTO props (model, spec) VALUES ('Master Airscrew 6040', '6mm Shaft');
INSERT INTO props (model, spec) VALUES ('HQProp 8040', '8mm Shaft');
INSERT INTO props (model, spec) VALUES ('Gemfan 1045', '10mm Shaft');
INSERT INTO props (model, spec) VALUES ('APC 1245', '12mm Shaft');

INSERT INTO motors (model, kv_rating) VALUES ('0802 Brushless Motors (2026) Champion', '28000KV');
INSERT INTO motors (model, kv_rating) VALUES ('0802 Brushless Motors (2026) Racing', '25000KV');
INSERT INTO motors (model, kv_rating) VALUES ('0802 Brushless Motors (2026) Freestyle', '22000KV');

INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Matrix 1S 5IN1 II Brushless Flight Controller', 8, 'ELRS', 'ACRO');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Matrix 1S 5IN1 II Brushless Flight Controller (Solder-free Version)', 8, 'ELRS', 'ACRO');
INSERT INTO flight_controllers (model, channel_count, control_link_protocol, control_mode) VALUES ('Matrix 1S 5IN1 II Brushless Flight Controller (Solder-required Version)', 8, 'ELRS', 'ACRO');

INSERT INTO cameras (model, resolution_mp) VALUES ('C03 Micro Camera', 2);
INSERT INTO cameras (model, resolution_mp) VALUES ('C03 FPV Micro Camera', 2);
INSERT INTO cameras (model, resolution_mp) VALUES ('C03', 2);

INSERT INTO frames (model, material) VALUES ('Air75 II Brushless Whoop Frame - Transparent Purple', 'PP');
INSERT INTO frames (model, material) VALUES ('Air75 II Brushless Whoop Frame - Transparent Blue', 'PP');
INSERT INTO frames (model, material) VALUES ('Air75 II Brushless Whoop Frame - Black', 'PP');

INSERT INTO batteries (model, capacity_mah) VALUES ('LAVA II 1S 480mAh', 480);
INSERT INTO batteries (model, capacity_mah) VALUES ('LAVA II 1S 580mAh', 580);
INSERT INTO batteries (model, capacity_mah) VALUES ('LAVA 1S 450mAh 75C Battery', 450);

INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Scout One',
	(SELECT id FROM flight_controllers WHERE model = 'Matek H743'),
	(SELECT id FROM cameras WHERE model = 'RunCam Phoenix 2'),
	(SELECT id FROM frames WHERE model = '250 Carbon X'),
	(SELECT id FROM batteries WHERE model = '4S 1300mAh'),
	(SELECT id FROM motors WHERE model = 'T-Motor F60 Pro'),
	(SELECT id FROM props WHERE model = 'Gemfan 51466'),
	'ANALOG',
	4,
	420,
	220,
	12,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Racer X',
	(SELECT id FROM flight_controllers WHERE model = 'Betaflight F4'),
	(SELECT id FROM cameras WHERE model = 'Foxeer Predator'),
	(SELECT id FROM frames WHERE model = '350 Racing Frame'),
	(SELECT id FROM batteries WHERE model = '4S 1500mAh'),
	(SELECT id FROM motors WHERE model = 'EMAX ECO II 2207'),
	(SELECT id FROM props WHERE model = 'HQProp 5x4x3'),
	'ANALOG',
	4,
	560,
	250,
	8,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Cine Glide',
	(SELECT id FROM flight_controllers WHERE model = 'SpeedyBee F7'),
	(SELECT id FROM cameras WHERE model = 'DJI O3 Air Unit'),
	(SELECT id FROM frames WHERE model = 'Cinewhoop Lite'),
	(SELECT id FROM batteries WHERE model = '6S 1500mAh'),
	(SELECT id FROM motors WHERE model = 'BrotherHobby Avenger 2306'),
	(SELECT id FROM props WHERE model = 'Dalprop 5x4.3x3'),
	'DIGITAL',
	4,
	680,
	280,
	14,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Long Range Ghost',
	(SELECT id FROM flight_controllers WHERE model = 'Holybro Kakute H7'),
	(SELECT id FROM cameras WHERE model = 'GoPro Hero 12'),
	(SELECT id FROM frames WHERE model = '7-inch Explorer'),
	(SELECT id FROM batteries WHERE model = '6S 2200mAh'),
	(SELECT id FROM motors WHERE model = 'iFlight XING2 2207'),
	(SELECT id FROM props WHERE model = 'Gemfan 7035'),
	'DIGITAL',
	2,
	980,
	330,
	28,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Cargo Hawk',
	(SELECT id FROM flight_controllers WHERE model = 'iFlight SucceX E'),
	(SELECT id FROM cameras WHERE model = 'RunCam Thumb Pro'),
	(SELECT id FROM frames WHERE model = 'Hexa Cargo'),
	(SELECT id FROM batteries WHERE model = '6S 3000mAh'),
	(SELECT id FROM motors WHERE model = 'SpeedX2 1404'),
	(SELECT id FROM props WHERE model = 'HQProp T5X4'),
	'ANALOG',
	6,
	1450,
	420,
	18,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Survey Pro',
	(SELECT id FROM flight_controllers WHERE model = 'Mamba F405'),
	(SELECT id FROM cameras WHERE model = 'Insta360 GO 3'),
	(SELECT id FROM frames WHERE model = 'VTOL Scout'),
	(SELECT id FROM batteries WHERE model = '2S 450mAh'),
	(SELECT id FROM motors WHERE model = 'RCINPOWER GTS V3'),
	(SELECT id FROM props WHERE model = 'Master Airscrew 6040'),
	'DIGITAL',
	8,
	2500,
	720,
	42,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Thermal Sweep',
	(SELECT id FROM flight_controllers WHERE model = 'Kiss FC'),
	(SELECT id FROM cameras WHERE model = 'Autel EVO Cam'),
	(SELECT id FROM frames WHERE model = 'Agriculture X8'),
	(SELECT id FROM batteries WHERE model = '3S 850mAh'),
	(SELECT id FROM motors WHERE model = 'GEPRC SPEEDX2 1505'),
	(SELECT id FROM props WHERE model = 'HQProp 8040'),
	'DIGITAL',
	4,
	3200,
	860,
	25,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Delivery Edge',
	(SELECT id FROM flight_controllers WHERE model = 'Cube Orange+'),
	(SELECT id FROM cameras WHERE model = 'Sony RX0 II'),
	(SELECT id FROM frames WHERE model = 'Heavy Lift Pro'),
	(SELECT id FROM batteries WHERE model = '8S 5000mAh'),
	(SELECT id FROM motors WHERE model = 'T-Motor F80'),
	(SELECT id FROM props WHERE model = 'Gemfan 1045'),
	'DIGITAL',
	4,
	5200,
	1000,
	35,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Industrial Scan',
	(SELECT id FROM flight_controllers WHERE model = 'Durandal'),
	(SELECT id FROM cameras WHERE model = 'Blackmagic Micro'),
	(SELECT id FROM frames WHERE model = '450 Long Range'),
	(SELECT id FROM batteries WHERE model = '6S 4000mAh'),
	(SELECT id FROM motors WHERE model = 'SunnySky X4108'),
	(SELECT id FROM props WHERE model = 'APC 1245'),
	'DIGITAL',
	2,
	4100,
	680,
	47,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Agri Titan',
	(SELECT id FROM flight_controllers WHERE model = 'Pixhawk 6X'),
	(SELECT id FROM cameras WHERE model = 'Caddx Polar'),
	(SELECT id FROM frames WHERE model = '250 Carbon X'),
	(SELECT id FROM batteries WHERE model = '12S 10000mAh'),
	(SELECT id FROM motors WHERE model = 'KDE 7215XF'),
	(SELECT id FROM props WHERE model = 'Gemfan 51466'),
	'DIGITAL',
	8,
	8600,
	2100,
	60,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Air75 II Racing',
	(SELECT id FROM flight_controllers WHERE model = 'Matrix 1S 5IN1 II Brushless Flight Controller'),
	(SELECT id FROM cameras WHERE model = 'C03 Micro Camera'),
	(SELECT id FROM frames WHERE model = 'Air75 II Brushless Whoop Frame - Transparent Purple'),
	(SELECT id FROM batteries WHERE model = 'LAVA II 1S 480mAh'),
	(SELECT id FROM motors WHERE model = '0802 Brushless Motors (2026) Racing'),
	(SELECT id FROM props WHERE model = 'GF 1614 3B Props'),
	'ANALOG',
	4,
	20,
	75,
	7,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Air75 II Freestyle',
	(SELECT id FROM flight_controllers WHERE model = 'Matrix 1S 5IN1 II Brushless Flight Controller'),
	(SELECT id FROM cameras WHERE model = 'C03 Micro Camera'),
	(SELECT id FROM frames WHERE model = 'Air75 II Brushless Whoop Frame - Transparent Blue'),
	(SELECT id FROM batteries WHERE model = 'LAVA II 1S 480mAh'),
	(SELECT id FROM motors WHERE model = '0802 Brushless Motors (2026) Freestyle'),
	(SELECT id FROM props WHERE model = 'Gemfan 1614 3-Blade Propellers'),
	'ANALOG',
	4,
	21,
	75,
	7,
	false
);
INSERT INTO drones (name, flight_controller_id, camera_id, frame_id, battery_id, motor_id, prop_id, video_link_type, props_count, weight_grams, wheelbase_mm, flight_time_minutes, is_deleted)
VALUES (
	'Air75 II Champion',
	(SELECT id FROM flight_controllers WHERE model = 'Matrix 1S 5IN1 II Brushless Flight Controller'),
	(SELECT id FROM cameras WHERE model = 'C03 Micro Camera'),
	(SELECT id FROM frames WHERE model = 'Air75 II Brushless Whoop Frame - Black'),
	(SELECT id FROM batteries WHERE model = 'LAVA II 1S 480mAh'),
	(SELECT id FROM motors WHERE model = '0802 Brushless Motors (2026) Champion'),
	(SELECT id FROM props WHERE model = 'Gemfan 1614 3-Blade Propellers'),
	'ANALOG',
	4,
	20,
	75,
	7,
	false
);
