대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

WITH valid_cars AS (
    SELECT car_id, COUNT(*) AS records
    FROM car_rental_company_rental_history
    WHERE
        start_date >= DATE '2022-08-01' AND
        start_date < DATE '2022-11-01'
    GROUP BY car_id
    HAVING COUNT(*) >= 5
)
SELECT
    EXTRACT(MONTH FROM c.start_date) AS month,
    v.car_id,
    COUNT(*) AS records
FROM car_rental_company_rental_history c
INNER JOIN valid_cars v ON v.car_id = c.car_id
WHERE
    c.start_date >= DATE '2022-08-01' AND
    c.start_date < DATE '2022-11-01'
GROUP BY v.car_id, EXTRACT(MONTH FROM c.start_date)
ORDER BY EXTRACT(MONTH FROM c.start_date), v.car_id DESC;

WITH base AS (
    SELECT car_id,
        EXTRACT(MONTH FROM start_date) AS month
    FROM car_rental_company_rental_history
    WHERE
        start_date >= DATE '2022-08-01' AND
        start_date < DATE '2022-11-01'
),
valid_cars AS (
    SELECT car_id
    FROM base
    GROUP BY car_id
    HAVING COUNT(*) >= 5
)
SELECT b.month, b.car_id, COUNT(*) AS records
FROM base b
INNER JOIN valid_cars v ON b.car_id = v.car_id
GROUP BY b.month, b.car_id
ORDER BY b.month, b.car_id DESC;

