// 연도별 대장균 크기의 편차 구하기

-- 코드를 작성해주세요 (1 시도)
SELECT
    YEAR(e.differentiation_date) AS `year`,
    (t.maxSize - e.size_of_colony) AS year_dev,
    e.id
FROM ecoli_data e
LEFT JOIN
    (
        SELECT MAX(size_of_colony) AS maxSize, YEAR(differentiation_date) AS stdYear
        FROM ecoli_data
        GROUP BY YEAR(differentiation_date)
    ) t ON t.stdYear = YEAR(e.differentiation_date)
ORDER BY e.differentiation_date, (t.maxSize - e.size_of_colony);

-- 코드를 작성해주세요 (2 시도)
WITH tmp AS (
    SELECT YEAR(differentiation_date) AS `year`,
    MAX(size_of_colony) AS maxSize
    FROM ecoli_data
    GROUP BY YEAR(differentiation_date)
)
SELECT
    t.year,
    (t.maxSize - e.size_of_colony) AS year_dev,
    e.id
FROM tmp t
RIGHT JOIN ecoli_data e ON YEAR(e.differentiation_date) = t.year
ORDER BY t.year, (t.maxSize - e.size_of_colony)

-- 코드를 작성해주세요 (3 시도)
SELECT
    YEAR(differentiation_date) AS `year`,
    MAX(size_of_colony) OVER(
        PARTITION BY YEAR(differentiation_date)
        ) - size_of_colony AS year_dev,
    id
FROM ecoli_data
ORDER BY `year`, year_dev