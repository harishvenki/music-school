INSERT INTO course_master_details (name) VALUES ('Classical Guitar');
INSERT INTO course_master_details (name) VALUES ('Piano Basics');
INSERT INTO course_master_details (name) VALUES ('Advanced Violin');
INSERT INTO course_master_details (name) VALUES ('Jazz Theory');
INSERT INTO course_master_details (name) VALUES ('Music Production');
INSERT INTO course_master_details (name) VALUES ('Vocal Training');
INSERT INTO course_master_details (name) VALUES ('Music Theory');
INSERT INTO course_master_details (name) VALUES ('Drum Basics');
INSERT INTO course_master_details (name) VALUES ('Composition Techniques');
INSERT INTO course_master_details (name) VALUES ('Electronic Music');

SELECT * FROM music_school.user_master_details;

INSERT INTO user_master_details (user_name, password, type)
VALUES ('alice_green', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('bob_white', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('carol_black', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('dave_brown', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('eva_johnson', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('frank_wilson', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('grace_lee', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('henry_martinez', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('ivy_garcia', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('jack_smith', 'password123', 'TEACHER');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('john_doe', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('jane_smith', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('emily_johnson', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('michael_brown', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('sarah_davis', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('david_wilson', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('olivia_moore', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('daniel_taylor', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('sophia_anderson', 'password123', 'STUDENT');

INSERT INTO user_master_details (user_name, password, type)
VALUES ('ethan_thomas', 'password123', 'STUDENT');


INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Alice', 'Green', '1234567890', 'New York', 'alice.green@example.com', 'alice_green_image.jpg', true, 1 , 1);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Bob', 'White', '2345678901', 'Los Angeles', 'bob.white@example.com', 'bob_white_image.jpg', true, 2, 2);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Carol', 'Black', '3456789012', 'Chicago', 'carol.black@example.com', 'carol_black_image.jpg', true, 3, 3);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Dave', 'Brown', '4567890123', 'Houston', 'dave.brown@example.com', 'dave_brown_image.jpg', false, 1, 4);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Eva', 'Johnson', '5678901234', 'Phoenix', 'eva.johnson@example.com', 'eva_johnson_image.jpg', true, 2, 5);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Frank', 'Wilson', '6789012345', 'Philadelphia', 'frank.wilson@example.com', 'frank_wilson_image.jpg', true, 3, 6);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Grace', 'Lee', '7890123456', 'San Antonio', 'grace.lee@example.com', 'grace_lee_image.jpg', true, 1, 7);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Henry', 'Martinez', '8901234567', 'San Diego', 'henry.martinez@example.com', 'henry_martinez_image.jpg', false, 2, 8);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Ivy', 'Garcia', '9012345678', 'Dallas', 'ivy.garcia@example.com', 'ivy_garcia_image.jpg', true, 3, 9);

INSERT INTO teacher_master_details (first_name, last_name, phone_number, city, email, display_image, status, course_id, user_id)
VALUES ('Jack', 'Smith', '0123456789', 'San Jose', 'jack.smith@example.com', 'jack_smith_image.jpg', true, 1, 10);


INSERT INTO batch_master_details (name, type, course_id, teacher_id)
VALUES ('Batch A1', 'Beginner', 1, 1);

INSERT INTO batch_master_details (name, type, course_id, teacher_id)
VALUES ('Batch B2', 'Intermediate', 2, 2);

INSERT INTO batch_master_details (name, type, course_id, teacher_id)
VALUES ('Batch C3', 'Advanced', 3, 3);

INSERT INTO batch_master_details (name, type, course_id, teacher_id)
VALUES ('Batch D4', 'Beginner', 4, 4);

INSERT INTO batch_master_details (name, type, course_id, teacher_id)
VALUES ('Batch E5', 'Intermediate', 5, 5);



INSERT INTO prize_master_details (name) VALUES ('Grand Champion');
INSERT INTO prize_master_details (name) VALUES ('Gold Medal');
INSERT INTO prize_master_details (name) VALUES ('Silver Medal');
INSERT INTO prize_master_details (name) VALUES ('Bronze Medal');
INSERT INTO prize_master_details (name) VALUES ('Best Performance');
INSERT INTO prize_master_details (name) VALUES ('Outstanding Achievement');
INSERT INTO prize_master_details (name) VALUES ('Most Promising Talent');
INSERT INTO prize_master_details (name) VALUES ('Exceptional Skill');
INSERT INTO prize_master_details (name) VALUES ('Top Contender');
INSERT INTO prize_master_details (name) VALUES ('Rising Star');
INSERT INTO prize_master_details (name) VALUES ('Judge’s Choice');
INSERT INTO prize_master_details (name) VALUES ('Audience Favorite');
INSERT INTO prize_master_details (name) VALUES ('Best Innovation');
INSERT INTO prize_master_details (name) VALUES ('Best Presentation');
INSERT INTO prize_master_details (name) VALUES ('Best Original Work');

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('John', 'Doe', '1234567890', 'john.doe@example.com', 'john_doe_image.jpg', 'A', 1, 1, 11);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Jane', 'Smith', '2345678901', 'jane.smith@example.com', 'jane_smith_image.jpg', 'A', 1, 2, 12);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Emily', 'Johnson', '3456789012', 'emily.johnson@example.com', 'emily_johnson_image.jpg', 'I', 2, 1, 13);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Michael', 'Brown', '4567890123', 'michael.brown@example.com', 'michael_brown_image.jpg', 'A', 3, 2, 14);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Sarah', 'Davis', '5678901234', 'sarah.davis@example.com', 'sarah_davis_image.jpg', 'A', 4, 1, 15);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('David', 'Wilson', '6789012345', 'david.wilson@example.com', 'david_wilson_image.jpg', 'I', 5, 1, 16);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Olivia', 'Moore', '7890123456', 'olivia.moore@example.com', 'olivia_moore_image.jpg', 'A', 3, 2, 17);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Daniel', 'Taylor', '8901234567', 'daniel.taylor@example.com', 'daniel_taylor_image.jpg', 'A', 6, 1, 18);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Sophia', 'Anderson', '9012345678', 'sophia.anderson@example.com', 'sophia_anderson_image.jpg', 'I', 1, 2, 19);

INSERT INTO student_master_details (first_name, last_name, phone_number, email, display_image, status, course_id, batch_id, user_id)
VALUES ('Ethan', 'Thomas', '0123456789', 'ethan.thomas@example.com', 'ethan_thomas_image.jpg', 'A', 7, 2, 20);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Classical Guitar Championship',
    '2024-09-01',
    '2024-09-10',
    1,
    'path/to/audio1.mp3',
    'path/to/video1.mp4',
    'A prestigious competition for classical guitarists.',
    'path/to/image1.jpg',
    'FUTURE'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Piano Solo Contest',
    '2024-09-15',
    '2024-09-20',
    2,
    'path/to/audio2.mp3',
    'path/to/video2.mp4',
    'An opportunity for pianists to showcase their solo performances.',
    'path/to/image2.jpg',
    'FUTURE'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Advanced Violin Recital',
    '2024-10-01',
    '2024-10-07',
    3,
    'path/to/audio3.mp3',
    'path/to/video3.mp4',
    'A recital for advanced violin students to demonstrate their skills.',
    'path/to/image3.jpg',
    'FUTURE'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Jazz Improvisation Battle',
    '2024-10-10',
    '2024-10-15',
    4,
    'path/to/audio4.mp3',
    'path/to/video4.mp4',
    'A competition to test jazz improvisation skills.',
    'path/to/image4.jpg',
    'PRESENT'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Music Production Showcase',
    '2024-11-01',
    '2024-11-05',
    5,
    'path/to/audio5.mp3',
    'path/to/video5.mp4',
    'Showcase of the best music production projects.',
    'path/to/image5.jpg',
    'PRESENT'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Vocal Performance Contest',
    '2024-11-10',
    '2024-11-15',
    6,
    'path/to/audio6.mp3',
    'path/to/video6.mp4',
    'A contest for vocalists to demonstrate their skills.',
    'path/to/image6.jpg',
    'PRESENT'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Music Theory Quiz',
    '2024-12-01',
    '2024-12-05',
    7,
    'path/to/audio7.mp3',
    'path/to/video7.mp4',
    'A quiz competition testing knowledge of music theory.',
    'path/to/image7.jpg',
    'PAST'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Drum Solo Competition',
    '2024-12-10',
    '2024-12-15',
    8,
    'path/to/audio8.mp3',
    'path/to/video8.mp4',
    'A competition for drum solos and performances.',
    'path/to/image8.jpg',
    'PAST'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Composition Techniques Challenge',
    '2024-12-20',
    '2024-12-25',
    9,
    'path/to/audio9.mp3',
    'path/to/video9.mp4',
    'A challenge to showcase composition techniques.',
    'path/to/image9.jpg',
    'PAST'
);

INSERT INTO competition_master_details (
    title,
    start_date,
    end_date,
    course_id,
    audio_files,
    video_files,
    description_text,
    image,
    status
) VALUES (
    'Electronic Music Remix Contest',
    '2024-12-30',
    '2024-12-31',
    10,
    'path/to/audio10.mp3',
    'path/to/video10.mp4',
    'A contest for the best electronic music remixes.',
    'path/to/image10.jpg',
    'PAST'
);
