// 대장균들의 자식의 수 구하기

-- 코드를 작성해주세요 mysql
SELECT t1.id, COALESCE(t2.cnt, 0) AS child_count
FROM ecoli_data t1
LEFT JOIN (
    SELECT parent_id, COUNT(*) AS cnt
    FROM ecoli_data
    GROUP BY parent_id
) t2 ON t2.parent_id = t1.id
ORDER BY t1.id;


