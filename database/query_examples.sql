USE green_univ;

-- 학생지원 >  수강신청 페이지에 나오는 과목들 조회
SELECT
`dept`.`name` AS `개설학과`,
`lec`.`classification` AS `구분`,
`lec`.`level` AS `학년`,
`lec`.id AS `코드`,
`lec`.`name` AS `과목명`,
`lec`.credit AS `학점`,
`user`.`name` AS `담당교수`,
`reg_lec`.registered_number AS `현재 수강신청 인원수`,
`reg_lec`.max_registered AS `최대 수강신청 인원수`
FROM `registry_lecture` AS `reg_lec`
JOIN `lecture` AS `lec`
ON `reg_lec`.`lecture_id` = `lec`.`id`
JOIN `department` AS  `dept`
ON `dept`.`id` = `lec`.`department_id`
JOIN `professor` AS `prof` 
ON `lec`.professor_id = prof.id
JOIN `user`
ON `user`.id = `prof`.user_id;

-- 식단 조회
SELECT
menu.main AS `메인요리`,
menu.soup AS `국`,
menu.rice AS `밥`,
menu.side_1 AS `반찬1`,
menu.side_2 AS `반찬2`,
meal.date AS `날짜`,
meal.meal_time AS `시간`
FROM `meal`
JOIN `menu`
ON menu.menu_id = meal.menu_id;

-- 학생정보 (학적) > 기본정보 조회
-- CASE 문을 사용하여 `student`.`status` 값을 [재학중, 졸업, 휴학]에 mapping
SELECT 
image.location AS `프로필 사진 경로`,
st.student_number AS `학번`,
`dept`.`name` AS `학과`,
`user`.`name` AS `이름`,
`user`.social_number AS `주민번호`,
`user`.contact AS `연락처`,
`user`.email AS `이메일`,
`st`.grade AS `학년`,
`st`.semester AS `학기`,
(CASE
	when `st`.`status` = "in" then "재학중"
	when `st`.`status` = "grad" then "졸업"
	when `st`.`status` = "break" then "휴학"
END) AS `상태`
FROM `student` AS `st`
JOIN `user`
ON `st`.user_id = `user`.id
JOIN `department` AS `dept`
ON `st`.department_id = dept.id
LEFT JOIN `image`
ON (`st`.image_id IS NOT NULL AND `st`.image_id= `image`.id)
WHERE student_number = "20250001";

-- 학생정보 (학적) > 기본정보 조회
-- CASE 문을 사용하지 않음. `student`.`status`의 값을 [재학중, 졸업, 휴학]에 매핑하는 로직은 스프링에서 수행
SELECT 
image.location AS `프로필 사진 경로`,
st.student_number AS `학번`,
`dept`.`name` AS `학과`,
`user`.`name` AS `이름`,
`user`.social_number AS `주민번호`,
`user`.contact AS `연락처`,
`user`.email AS `이메일`,
`st`.grade AS `학년`,
`st`.semester AS `학기`,
`st`.`status` AS `상태`
FROM `student` AS `st`
JOIN `user`
ON `st`.user_id = `user`.id
JOIN `department` AS `dept`
ON `st`.department_id = dept.id
LEFT JOIN `image`
ON (`st`.image_id IS NOT NULL AND `st`.image_id= `image`.id)
WHERE student_number = "20250003";

-- 학생정보(학적) > 취득학점현황
-- 전공 취득학점
SELECT
*
FROM `registry` AS reg
JOIN `student` AS `std`
ON `reg`.student_number = `std`.student_number
JOIN `registry_lecture` AS `reg_lec`
ON `reg`.registry_lecture_id = `reg_lec`.lecture_id
JOIN `lecture` AS `lec`
ON `reg_lec`.lecture_id = `lec`.id
WHERE `std`.student_number = "20250001";