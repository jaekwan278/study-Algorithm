년, 월, 성별 별 상품 구매 회원 수 구하기

-- 코드를 입력하세요
SELECT
    EXTRACT(YEAR FROM s.sales_date) AS year,
    EXTRACT(MONTH FROM s.sales_date) AS month,
    i.gender, COUNT(DISTINCT s.user_id) AS users
FROM online_sale s
INNER JOIN user_info i ON s.user_id = i.user_id
WHERE i.gender IS NOT NULL
GROUP BY year, month, i.gender
ORDER BY year, month, i.gender;