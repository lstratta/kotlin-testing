
---------- Products and Orders -------------

INSERT INTO orders (
    order_key,
    order_id,
    total_value
) VALUES
( 101, '38ca91e6-3f17-4fa5-9a33-9a7679812e1b', 142.50 );

INSERT INTO products (
    product_key,
    product_id,
    name,
    description,
    item_price,
    order_key
) VALUES
(
    1,
    'c3f4eda1-6c3f-40ba-a625-ece36cee0284',
    'Adeptus Mechanicus Skitarii Marshall',
    'Lead your Skitarii forces with the new Marshall!',
    20.00,
    101
),
(
    2,
    '092ad66f-5746-407f-aa55-963413a87f1b',
    'Adeptus Mechanicus Skitarii',
    'The backbone of any Mechanicus army.',
    27.50,
    101
),
(
    3,
    'c6ad4293-8484-49c9-8da5-c32212b55fda',
    'Adeptus Mechanicus Sicarian Rustalkers',
    'Catch your enemies off-guard with these sneaky, stabby, Sicarians.',
    30.00,
    101
),
(
    4,
    '42eb18d5-a866-4707-b56a-6cc428d391a3',
    'Adeptus Mechanicus Sicarian Infiltrators',
    'Go behind enemy lines, gather intel, and cause chaos in the shadows with these Sicarian Infiltrators.',
    30.00,
    101
),
(
    5,
    '0a8c9724-726a-473c-9c98-6e38b9a15e9a',
    'Adeptus Mechanicus Kataphron Destroyers',
    'Destroy the enemies of the Omnissiah from afar with the Kataphron Destroyers',
    35.00,
    101
);



---------- Students and Courses -----------

--CREATE TABLE student (
--    student_key BIGINT PRIMARY KEY,
--    student_id BINARY,
--    first_name VARCHAR(255),
--    last_name VARCHAR(255)
--    -- enrolled_on is a many to many thing
--);
--
--CREATE TABLE course (
--    course_key BIGINT PRIMARY KEY,
--    course_id BINARY,
--    course_name VARCHAR(255)
--    -- students_enrolled is a many to many thing
--);
