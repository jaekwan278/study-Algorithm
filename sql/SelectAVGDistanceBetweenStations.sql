노선별 평균 역 사이 거리 조회하기

-- 코드를 작성해주세요
SELECT route,
    CONCAT( ROUND( SUM(d_between_dist), 1), 'km') AS TOTAL_DISTANCE,
    CONCAT( ROUND( AVG(d_between_dist), 2), 'km') AS AVERAGE_DISTANCE
FROM subway_distance
GROUP BY route
ORDER BY SUM(d_between_dist) DESC;