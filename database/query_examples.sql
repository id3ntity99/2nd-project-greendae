USE green_univ;

###################################### 식단 ###############################
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
ON menu.id = meal.menu_id;

###################################### 학생정보(학적)  ###############################
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
`img`.location AS `image_location`,
st.student_number AS `student_number`,
`dept`.`name` AS `department_name`,
`user`.`name` AS `user_name`,
`user`.social_number AS `social_number`,
`user`.contact AS `user_contact`,
`user`.email AS `user_email`,
`st`.grade AS `student_grade`,
`st`.semester AS `student_semester`,
`st`.current_credit AS `current_credit`,
`st`.graduation_credit AS `graduation_credit`,
`st`.`status` as `student_status`
FROM `student` AS `st`
JOIN `user`
ON `st`.user_id = `user`.id
JOIN `department` AS `dept`
ON `st`.department_id = dept.id
LEFT JOIN `image` AS `img`
ON (`st`.image_id IS NOT NULL AND `st`.image_id = `img`.id)
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

###################################### 강의 ###############################
-- 강의목록 전체 조회
SELECT
`lec`.id AS `lecture_code`,
`dept`.`name` AS `department_name`,
`lec_info`.`level` AS `lecture_level`,
`lec_info`.classification AS `lec_classification`,
`lec_info`.`name` AS `lecture_name`,
`user`.`name` AS `professor_name`,
`lec_info`.credit AS `lec_credit`,
`lec_d`.`day` AS `lecture_day`,
`lec_t`.start_at AS `lecture_starts`,
`lec_t`.end_at AS `lecture_ends`
FROM `lecture` AS `lec`
JOIN `lecture_info` AS `lec_info`
ON `lec`.id= `lec_info`.id
JOIN `professor` AS `prof`
ON `lec_info`.professor_id = `prof`.id
JOIN `user`
ON `prof`.user_id = `user`.id
JOIN `department` AS `dept`
ON `dept`.id = `lec_info`.department_id
JOIN `lecture_day` AS `lec_d`
ON `lec`.lecture_day_id = `lec_d`.id
JOIN `lecture_time` AS `lec_t`
ON `lec`.lecture_time_id = `lec_t`.id
GROUP BY `lec`.id;


###################################### 수강신청 ###############################
-- 수강신청 목록 조회(개설학과, 구분, 학년, 코드, 과목명, 학점, 담당교수, 현재수강인원, 최대수강인원)
SELECT
`dept`.`name` AS `department_name`,
`lec_info`.classification AS `lecture_classification`,
`lec_info`.`level` AS `lecture_level`,
`lec_info`.id AS `lecture_code`,
`lec_info`.`name` AS `lecture_name`,
`lec_info`.credit AS `lecture_credit`,
`user`.`name` AS `professor_name`,
`reg_lec`.registered_number AS `registered_number`,
`reg_lec`.max_registered AS `max_registered`
FROM `registry_lecture` AS `reg_lec`
JOIN `lecture` AS `lec`
ON `reg_lec`.id = `lec`.id
JOIN `lecture_info` AS `lec_info`
ON `lec`.id = `lec_info`.id
JOIN `department` AS `dept`
ON `lec_info`.department_id = `dept`.id
JOIN `professor` AS `prof`
ON `lec_info`.professor_id = `prof`.id
JOIN `user`
ON `prof`.user_id = `user`.id;

-- 수강신청 목록 조회LIMIT
SELECT
`dept`.`name` AS `department_name`,
`lec_info`.classification AS `lecture_classification`,
`lec_info`.`level` AS `lecture_level`,
`lec_info`.id AS `lecture_code`,
`lec_info`.`name` AS `lecture_name`,
`lec_info`.credit AS `lecture_credit`,
`user`.`name` AS `professor_name`,
`reg_lec`.registered_number AS `registered_number`,
`reg_lec`.max_registered AS `max_registered`
FROM `registry_lecture` AS `reg_lec`
JOIN `lecture` AS `lec`
ON `reg_lec`.id = `lec`.id
JOIN `lecture_info` AS `lec_info`
ON `lec`.id = `lec_info`.id
JOIN `department` AS `dept`
ON `lec_info`.department_id = `dept`.id
JOIN `professor` AS `prof`
ON `lec_info`.professor_id = `prof`.id
JOIN `user`
ON `prof`.user_id = `user`.id
LIMIT 1, 3;

-- 수강신청 이름으로 조회
SELECT
`dept`.`name` AS `department_name`,
`lec_info`.classification AS `lecture_classification`,
`lec_info`.`level` AS `lecture_level`,
`lec_info`.id AS `lecture_code`,
`lec_info`.`name` AS `lecture_name`,
`lec_info`.credit AS `lecture_credit`,
`user`.`name` AS `professor_name`,
`reg_lec`.registered_number AS `registered_number`,
`reg_lec`.max_registered AS `max_registered`
FROM `registry_lecture` AS `reg_lec`
JOIN `lecture` AS `lec`
ON `reg_lec`.id = `lec`.id
JOIN `lecture_info` AS `lec_info`
ON `lec`.id = `lec_info`.id
JOIN `department` AS `dept`
ON `lec_info`.department_id = `dept`.id
JOIN `professor` AS `prof`
ON `lec_info`.professor_id = `prof`.id
JOIN `user`
ON `prof`.user_id = `user`.id
WHERE `lec_info`.`name` = "세계역사";

-- 수강신청 아이디로 조회
SELECT
`dept`.`name` AS `department_name`,
`lec_info`.classification AS `lecture_classification`,
`lec_info`.`level` AS `lecture_level`,
`lec_info`.id AS `lecture_code`,
`lec_info`.`name` AS `lecture_name`,
`lec_info`.credit AS `lecture_credit`,
`user`.`name` AS `professor_name`,
`reg_lec`.registered_number AS `registered_number`,
`reg_lec`.max_registered AS `max_registered`
FROM `registry_lecture` AS `reg_lec`
JOIN `lecture` AS `lec`
ON `reg_lec`.id = `lec`.id
JOIN `lecture_info` AS `lec_info`
ON `lec`.id = `lec_info`.id
JOIN `department` AS `dept`
ON `lec_info`.department_id = `dept`.id
JOIN `professor` AS `prof`
ON `lec_info`.professor_id = `prof`.id
JOIN `user`
ON `prof`.user_id = `user`.id
WHERE `lec_info`.`id` = "304011";

###################################### 수강신청내역 ###############################
-- 학번으로 수강신청내역 조회(교과목코드, 과목명, 대상학년, 담당교수, 학점, 이수구분, 강의시간, 강의장)
USE green_univ;
SELECT 
`reg`.`student_number` AS `student_number`,
`lec_info`.id AS `lecture_code`,
`lec_info`.`name` AS `lecture_name`,
`lec_info`.`level` AS `lecture_level`,
`user`.`name` AS `professor_name`,
`lec_info`.credit AS `lecture_credit`,
`lec_info`.classification	AS `lecture_classification`,
`lec_d`.`day` AS `lecture_day`,
`lec_t`.start_at AS `lecture_start_at`,
`lec_t`.end_at AS `lecture_end_at`,
`lec_info`.classroom AS `lecture_classroom`,
`reg`.`current_year` AS `current_year`,
`reg`.`register_date` AS `register_date`
FROM `registry` AS `reg`
JOIN `registry_lecture` AS `reg_lec`
ON `reg`.id = `reg_lec`.id
JOIN `lecture` AS `lec`
ON `reg_lec`.id = `lec`.id
JOIN `lecture_info` AS `lec_info`
ON `lec`.id = `lec_info`.id
JOIN `lecture_day` AS `lec_d`
ON `lec`.lecture_day_id = `lec_d`.id
JOIN `lecture_time` AS `lec_t`
ON `lec`.lecture_time_id = `lec_t`.id
JOIN `professor` AS `prof`
ON `prof`.id = `lec_info`.professor_id
JOIN `user`
ON `prof`.user_id = `user`.id
WHERE `reg`.student_number = "20250001";


