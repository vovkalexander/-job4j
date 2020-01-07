--1) Retrieve in a single query:
--- names of all persons that are NOT in the company with id = 5
--- company name for each person
Select p.name, c.name  from company as c
LEFT OUTER JOIN person as p
ON p.company_id = c.id
AND p.company_id not in(5);

--2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT c.name, COUNT(*) AS quant FROM company AS c
INNER JOIN person AS p 
ON p.company_id=c.id
GROUP BY c.name
ORDER BY quant desc
LIMIT 1;


 

