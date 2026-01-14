특정 조건을 만족하는 물고기별 수와 최대 길이 구하기

-- 코드를 작성해주세요
SElECT COUNT(id) AS fish_count, MAX(length) AS max_length, fish_type
FROM fish_info
GROUP BY fish_type
HAVING AVG(COALESCE(length, 10)) >= 33
ORDER BY fish_type;