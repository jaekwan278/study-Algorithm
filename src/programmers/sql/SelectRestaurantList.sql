// 그룹별 조건에 맞는 식당 목록 출력하기

-- 코드를 입력하세요 mysql
WITH top_members AS (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING COUNT(*) = (
        SELECT MAX(cnt)
        FROM (
            SELECT COUNT(*) AS cnt
            FROM rest_review
            GROUP BY member_id
        ) tmp
    )
),
top_members_review AS (
    SELECT r.member_id, r.review_text, r.review_date
    FROM rest_review r
    INNER JOIN top_members tm ON tm.member_id = r.member_id
)
SELECT m.member_name, tmr.review_text, DATE_FORMAT(tmr.review_date, '%Y-%m-%d') AS review_date
FROM top_members_review tmr
INNER JOIN member_profile m ON m.member_id = tmr.member_id
ORDER BY tmr.review_date ASC, tmr.review_text DESC;


-- 코드를 입력하세요 mysql
SELECT m.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d') AS review_date
FROM rest_review r
INNER JOIN member_profile m ON m.member_id = r.member_id
WHERE r.member_id IN (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING COUNT(*) = (
        SELECT MAX(cnt)
        FROM (
            SELECT COUNT(*) AS cnt
            FROM rest_review
            GROUP BY member_id
        ) tmp
    )
)
ORDER BY r.review_date, r.review_text;


-- 코드를 입력하세요 oracle
SELECT m.member_name, r.review_text, TO_CHAR(r.review_date, 'YYYY-MM-DD') AS review_date
FROM rest_review r
INNER JOIN (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING COUNT(*) = (
        SELECT MAX(cnt)
        FROM (
            SELECT COUNT(*) AS cnt
            FROM rest_review r
            GROUP BY member_id
        ) sr
    )
) tm ON tm.member_id = r.member_id
INNER JOIN member_profile m ON tm.member_id = m.member_id
ORDER BY r.review_date, r.review_text;


-- 코드를 입력하세요 oracle
SELECT m.member_name, r.review_text, TO_CHAR(r.review_date, 'YYYY-MM-DD') AS review_date
FROM (
    SELECT
        r.*,
        RANK() OVER( ORDER BY COUNT(*) OVER( PARTITION BY member_id) DESC) AS rank
    FROM rest_review r
) r
INNER JOIN member_profile m ON m.member_id = r.member_id
WHERE r.rank = 1
ORDER BY r.review_date, r.review_text;
