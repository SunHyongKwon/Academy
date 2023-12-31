create or replace function add_event(
    title text,
    starts timestamp,
    ends timestamp,
    venue text,
    postal varchar(9),
    country char(2)
)
returns boolean as $$
declare 
did_insert boolean := false;
found_count integer;
the_venue_id integer;
begin
select venue_id into the_venue_id 
from venues v
where v.postal_code=postal and v.country_code=country and v.name ILIKE venue limit 1;

if the_venue_id is null then
insert into venues (name, postal_code, country_code)
values (venue, postal, country)
RETURNING venue_id into the_venue_id;

did_insert := true;
end if;

--참고: 일부 프그밍 언어에서처럼 "에러"가 아다.
raise notice 'Venue found %', the_venue_id;

insert into events (title,starts,ends,venue_id)
values (title, starts, ends, the_venue_id);

return did_insert;
end;
$$ language plpgsql;