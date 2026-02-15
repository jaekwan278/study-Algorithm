-- 오프라인/온라인 판매 데이터 통합하기

-- 코드를 입력하세요
SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date, product_id, user_id, sales_amount
FROM online_sale
WHERE sales_date >= '2022-03-01' AND sales_date < '2022-04-01'

UNION ALL

SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date, product_id, CAST(NULL AS SIGNED) AS user_id, sales_amount
FROM offline_sale
WHERE sales_date >= '2022-03-01' AND sales_date < '2022-04-01'

ORDER BY sales_date, product_id, user_id;

-- 코드를 입력하세요 (가독성 향샹 <> 성능 감소 = 사전 필터 처리 없음)
SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date, product_id, user_id, sales_amount
FROM
(
    SELECT sales_date, product_id, user_id, sales_amount
    FROM online_sale

    UNION ALL

    SELECT sales_date, product_id, NULL AS user_id, sales_amount
    FROM offline_sale
) t
WHERE sales_date >= '2022-03-01' AND sales_date < '2022-04-01'
ORDER BY sales_date, product_id, user_id;