CREATE OR REPLACE PROCEDURE create_item 
(
	item_id	IN VARCHAR2,
	project_id IN VARCHAR2,
	name IN VARCHAR2,
	img	IN VARCHAR2,
	total_donation IN FLOAT
) 
IS
BEGIN

	INSERT INTO Item
	VALUES(item_id, project_id, name, img, 0.00);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'Donor ID already exists / duplicate id');

END create_item;