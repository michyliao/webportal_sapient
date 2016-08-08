create type donations_object is object(
donation_id Donations.donation_id%TYPE,
donor_id Donations.donor_id%TYPE,
type_id Donations.type_id%TYPE,
type Donations.type%TYPE,
amount Donations.amount%TYPE
);

create type donation_tab is table of donations_object;

create or replace function all_donations return donation_tab
	is 
	l_donations_tab donation_tab := donation_tab();
	n integer := 0;

	begin
	for r in (select * from Donations){
	loop
		l_donations_tab.extend;
		n := n + 1;
		l_donations_tab(n) := donations_object(r.donation_id, r.donor_id, r.type_id, r.type, r.amount);
	end loop;
	return l_donations_tab;	
	}