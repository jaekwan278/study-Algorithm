연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기

WITH score AS (
    SELECT e.emp_no, e.emp_name,
        CASE
            WHEN (SUM(g.score) / 2) >= 96 THEN 'S'
            WHEN (SUM(g.score) / 2) >= 90 THEN 'A'
            WHEN (SUM(g.score) / 2) >= 80 THEN 'B'
            ELSE 'C'
        END AS 'grade',
        e.sal
    FROM hr_employees e
    INNER JOIN hr_grade g ON e.emp_no = g.emp_no
    GROUP BY e.emp_no, e.emp_name, e.sal
)
SELECT emp_no, emp_name, grade,
    CASE
        WHEN grade = 'S' THEN (sal * 0.2)
        WHEN grade = 'A' THEN (sal * 0.15)
        WHEN grade = 'B' THEN (sal * 0.1)
        ELSE 0
    END AS 'bonus'
FROM score
ORDER BY emp_no;