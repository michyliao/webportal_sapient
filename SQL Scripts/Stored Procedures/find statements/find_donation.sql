CREATE OR REPLACE PROCEDURE find_donation
(
	in_donor_name IN Donor.name%TYPE,
	in_project_name IN Project.name%TYPE,
	in_item_name IN Item.name%TYPE,
	in_portal_name IN Portal.name%TYPE,
	
	out_id OUT Donations.donation_id%TYPE,
	out_donorID OUT Donations.donor_id%TYPE,
	out_typeID OUT Donations.type_id%TYPE,
	out_type OUT Donations.type%TYPE,
	out_amount OUT Donations.amount%TYPE
) 
IS
BEGIN
	select donation.donation_id, donation.donor_id, donation.type_id, donation.type, donation.amount
	INTO out_id, out_donorID, out_typeID, out_type, out_amount
	from Donations donation
	inner join Donor donor on donor.donor_id = donation.donor_id
	inner join Project proj on proj.project_id = donation.type_id
	inner join Item item on item.item_id = donation.type_id
	inner join Portal port on port.portal_id = donation.type_id
	where donor.name = in_donor_name or proj.name = in_portal_name
	or item.name = in_item_name or port.name = in_portal_name;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_donation;