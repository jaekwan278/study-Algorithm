분기별 분화된 대장균의 개체 수 구하기

-- 코드를 작성해주세요
SELECT
    CASE
        WHEN MONTH(differentiation_date) < 4 THEN '1Q'
        WHEN MONTH(differentiation_date) < 7 THEN '2Q'
        WHEN MONTH(differentiation_date) < 10 THEN '3Q'
        ELSE '4Q'
    END AS QUARTER,
    COUNT(*) AS ECOLI_COUNT
FROM ecoli_data
GROUP BY
    CASE
        WHEN MONTH(differentiation_date) < 4 THEN '1Q'
        WHEN MONTH(differentiation_date) < 7 THEN '2Q'
        WHEN MONTH(differentiation_date) < 10 THEN '3Q'
        ELSE '4Q'
    END
ORDER BY QUARTER ASC;

-- 코드를 작성해주세요
SELECT quarter, COUNT(*) AS ecoli_count
FROM (
    SELECT
        CASE
            WHEN MONTH(differentiation_date) < 4 THEN '1Q'
            WHEN MONTH(differentiation_date) < 7 THEN '2Q'
            WHEN MONTH(differentiation_date) < 10 THEN '3Q'
            ELSE '4Q'
        END AS quarter
    FROM ecoli_data
) t
GROUP BY quarter
ORDER BY quarter ASC;

-- 코드를 작성해주세요 ( 비권장 ( 가독성 ))
SELECT
    CASE
        WHEN MONTH(DIFFERENTIATIONDATE) BETWEEN 1 AND 3 THEN '1Q'
        WHEN MONTH(DIFFERENTIATIONDATE) BETWEEN 4 AND 6 THEN '2Q'
        WHEN MONTH(DIFFERENTIATIONDATE) BETWEEN 7 AND 9 THEN '3Q'
        WHEN MONTH(DIFFERENTIATIONDATE) BETWEEN 10 AND 12 THEN '4Q'
    END AS QUARTER,
    COUNT(ID) AS ECOLICOUNT
FROM ECOLIDATA
GROUP BY 1
ORDER BY QUARTER

-- 코드를 작성해주세요 ( 비권장 ( 가독성 ))

SELECT quarter, COUNT(*) AS ecoli_count
FROM
(
    SELECT CONCAT(QUARTER(differentiation_date), 'Q') AS quarter
    FROM ecoli_data
) t
GROUP BY quarter
ORDER BY quarter ASC;