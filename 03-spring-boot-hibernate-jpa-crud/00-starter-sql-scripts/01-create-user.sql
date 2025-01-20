-- Drop the user if it exists
DROP USER IF EXISTS 'springstudent'@'localhost';

-- Create the user with the desired password
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

-- Grant privileges on a specific database (recommended approach)
-- GRANT ALL PRIVILEGES ON my_database.* TO 'springstudent'@'localhost';

-- Or grant privileges to all databases (less secure)
GRANT ALL PRIVILEGES ON *.* TO 'springstudent'@'localhost';

-- Apply the changes
FLUSH PRIVILEGES;
