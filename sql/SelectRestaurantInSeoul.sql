서울에 위치한 식당 목록 출력하기

-- 코드를 입력하세요
SELECT i.rest_id, i.rest_name, i.food_type, i.favorites, i.address,
    ROUND(AVG(r.review_score), 2) AS SCORE
FROM rest_info i
INNER JOIN rest_review r ON i.rest_id = r.rest_id
WHERE i.address LIKE '서울%'
GROUP BY i.rest_id
ORDER BY score DESC, i.favorites DESC;