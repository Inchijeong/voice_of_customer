INSERT INTO driver(driver_id, name, phone_number, salary, created_date, modified_date)
VALUES (null, '기사 이름', '01012345678', 400, now(), now());

INSERT INTO company(company_id, name, phone_number, created_date, modified_date)
VALUES (null, '운송사 이름', '01012345678', now(), now());

INSERT INTO voc(voc_id, party, manager_name, details, claim_yn, compensation_request_yn, driver_id, created_date, modified_date)
VALUES (null, '기사', '매니저 이름', '내용', true, true, 1, now(), now());

INSERT INTO reparation(reparation_id, amount, details, voc_id, created_date, modified_date)
VALUES (null, 10000, '내용', 1, now(), now());
