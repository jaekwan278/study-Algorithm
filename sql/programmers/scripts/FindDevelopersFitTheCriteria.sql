-- 조건에 맞는 개발자 찾기
-- MySQL

SELECT id, email, first_name, last_name
FROM developers
where skill_code &
(
	SELECT SUM(code)
	FROM skillcodes
	WHERE name IN ('C#', 'Python')
) > 0
ORDER BY id;