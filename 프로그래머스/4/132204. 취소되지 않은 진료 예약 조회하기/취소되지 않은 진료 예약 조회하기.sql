-- 코드를 입력하세요
SELECT a.apnt_no, pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd from PATIENT p, DOCTOR d, APPOINTMENT a
where p.pt_no = a.pt_no and a.mddr_id = d.dr_id and a.MCDP_CD = 'CS'
    and year(APNT_YMD) = 2022 and month(APNT_YMD) = 4 and day(APNT_YMD) = 13 and APNT_CNCL_YN ='N'
order by apnt_ymd