조건에 맞는 중고거래 댓글 조회하기

-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, '%Y-%m-%d') AS created_date
FROM used_goods_board b
INNER JOIN used_goods_reply r ON r.board_id = b.board_id
WHERE b.created_date >= '2022-10-01' AND b.created_date < '2022-11-01'
ORDER BY r.created_date ASC, b.title ASC;