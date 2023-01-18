
---------- Products and Orders -------------

--CREATE TABLE products (
--    product_key BIGINT PRIMARY KEY,
--    product_id UUID,
--    name VARCHAR(255),
--    description VARCHAR(255),
--    item_price DOUBLE
--);

--CREATE TABLE orders (
--    order_key BIGINT PRIMARY KEY,
--    order_id UUID,
--    totalValue DOUBLE
--);

INSERT INTO products (
    product_key,
    product_id,
    name,
    description,
    item_price
) VALUES
( 1, 'c3f4eda1-6c3f-40ba-a625-ece36cee0284', 'Adeptus Mechanicus Skitarii Marshall', 'Lead your Skitarii forces with the new Marshall!', 20.00 ),
( 2, '092ad66f-5746-407f-aa55-963413a87f1b', 'Adeptus Mechanicus Skitarii', 'The backbone of any Mechanicus army.', 27.50 ),
( 3, 'c6ad4293-8484-49c9-8da5-c32212b55fda', 'Adeptus Mechanicus Sicarian Rustalkers', 'Catch your enemies off-guard with these sneaky, stabby, Sicarians.', 30.00 ),
( 4, '42eb18d5-a866-4707-b56a-6cc428d391a3', 'Adeptus Mechanicus Skitarii Infiltrators', 'Go behind enemy lines, gather intel, and cause chaos in the shadows with these Sicarian Infiltrators.', 30.00 ),
( 5, '0a8c9724-726a-473c-9c98-6e38b9a15e9a', 'Adeptus Mechanicus Kataphron Destroyers', 'Destroy the enemies of the Omnissiah from afar with the Kataphron Destroyers', 35.00 );

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
