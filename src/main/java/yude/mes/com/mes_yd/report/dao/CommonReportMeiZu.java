package yude.mes.com.mes_yd.report.dao;
import org.apache.ibatis.annotations.Select;
import yude.mes.com.mes_yd.report.domain.CommonReportMeiZuVO;

import java.util.List;
import java.util.Map;

public interface CommonReportMeiZu {

    List<CommonReportMeiZuVO> selectByPalletCode(Map<String,Object> map);

    @Select("    WITH SUB AS\n" +
            " (SELECT T1.RCARD,\n" +
            "         T1.mcard,\n" +
            "         t1.MITEMCODE,\n" +
            "         T3.VENDORCODE,\n" +
            "         T4.MATERIALTYPECLASS AS \"TYPE\",\n" +
            "         T2.MOCODE,\n" +
            "         T2.PalletCode,\n" +
            "         to_char(to_date(T2.mdate || lpad(T2.mtime, 6, 0),'YYYY-MM-DD HH24:MI:SS'),'yyyy-MM-dd HH:mm:ss') as PalletTime,\n" +
            "        REGEXP_SUBSTR(t3.mname,'[a-zA-Z0-9_-]+',1,1,'i') as  mname\n" +
            "    FROM TBLONWIPITEM    T1,\n" +
            "         TBLPALLET2RCARD T2,\n" +
            "         TBLMATERIAL     T3,\n" +
            "         TBLOPBOMDETAIL  T4\n" +
            "   WHERE T1.RCARD = T2.RCARD\n" +
            "     AND T1.MITEMCODE = T3.MCODE\n" +
            "     AND T1.MITEMCODE = T4.OBITEMCODE\n" +
            "     \n" +
            "        AND T2.Palletcode = #{palletCode}\n" +
            "    ),\n" +
            "     SUB2 as (\n" +
            "     select T2.RCARD,\n" +
            "            T1.mcard,\n" +
            "            t1.MITEMCODE,\n" +
            "            T3.VENDORCODE,\n" +
            "            T4.MATERIALTYPECLASS  \"TYPE\",\n" +
            "            T2.MOCODE,\n" +
            "            T2.PalletCode,\n" +
            "            T2.PalletTime,\n" +
            "            T2.mname\n" +
            "       from TBLONWIPITEM t1, SUB t2, TBLMATERIAL t3, TBLOPBOMDETAIL t4\n" +
            "      where t1.rcard = t2.mcard\n" +
            "        AND T1.MITEMCODE = T3.MCODE\n" +
            "        AND T1.MITEMCODE = T4.OBITEMCODE\n" +
            "     ),keyparts as\n" +
            " (SELECT RCARD,\n" +
            "         MIN(Palletcode) as Palletcode ,\n" +
            "         MIN(CASE TYPE WHEN 'TP' THEN MCARD ELSE '' END) AS TP,\n" +
            "         MIN(CASE TYPE WHEN 'BATTERY' THEN MCARD ELSE '' END) AS BATTERY,\n" +
            "         MIN(CASE TYPE WHEN 'BATTERY' THEN vendorcode ELSE '' END) AS BatterySupplier,\n" +
            "         MIN(CASE TYPE WHEN 'FRONTCAMERA' THEN MCARD ELSE '' END) AS FrontCamera,\n" +
            "         MIN(CASE TYPE WHEN 'FRONTCAMERA' THEN vendorcode ELSE '' END) AS FrontCameraSupplier,\n" +
            "         MIN(CASE TYPE WHEN 'BACKCAMERA' THEN MCARD ELSE '' END) AS BackCamera,\n" +
            "         MIN(CASE TYPE WHEN 'BACKCAMERA' THEN vendorcode ELSE '' END) AS BackCameraSupplier,\n" +
            "         min(mname) mname,\n" +
            "         MIN(CASE TYPE WHEN 'FAN' THEN MCARD ELSE '' END) AS FAN,\n" +
            "         MIN(CASE TYPE WHEN 'OBD' THEN MCARD ELSE '' END) AS OBD\n" +
            "\n" +
            "         ,MIN(CASE TYPE WHEN 'BATTERY COVER' THEN MCARD ELSE '' END) AS BATTERYCOVER\n" +
            "         ,MIN(CASE TYPE WHEN 'FRONT CASE' THEN MCARD ELSE '' END) AS FRONTCASE\n" +
            "         ,MIN(CASE TYPE WHEN 'PLATELET' THEN MCARD ELSE '' END) AS PLATELET\n" +
            "    FROM SUB2\n" +
            "   GROUP BY RCARD),\n" +
            "keyparttime as\n" +
            " (select t1.rcard,\n" +
            "         MAX(case opcode when 'IMEI' then to_char(to_date(t1.mdate || lpad(t1.mtime, 6, 0), 'YYYY-MM-DD HH24:MI:SS'), 'yyyy-MM-dd HH:mm:ss') else '' end) as IMEIWriteTime,\n" +
            "         MAX(case opcode when 'LABELPRINT' then to_char(to_date(t1.mdate || lpad(t1.mtime, 6, 0), 'YYYY-MM-DD HH24:MI:SS'), 'yyyy-MM-dd HH:mm:ss') else '' end) as BoxTime,\n" +
            "         MAX(case opcode when 'PACKING' then to_char(to_date(t1.mdate || lpad(t1.mtime, 6, 0), 'YYYY-MM-DD HH24:MI:SS'), 'yyyy-MM-dd HH:mm:ss') else '' end) as PackTime,\n" +
            "         MAX(case opcode when 'CHECKVER' then  to_char(to_date(t1.mdate || lpad(t1.mtime, 6, 0),'YYYY-MM-DD HH24:MI:SS'),'yyyy-MM-dd HH:mm:ss') else '' end) as EncryptTime\n" +
            "    from tblonwip t1, sub t2\n" +
            "   where t1.MOCODE = t2.mocode\n" +
            "     and t1.rcard = t2.rcard\n" +
            "   group by t1.rcard),\n" +
            "keypartweight as\n" +
            " (select w.rcard, max(w.weight) as weight\n" +
            "    from tblrcard2weight w, sub s\n" +
            "   where w.rcard = s.rcard\n" +
            "   group by w.rcard)\n" +
            " ,keypartData as (\n" +
            " select K1.RCARD,\n" +
            "        K1.PalletCode,\n" +
            "        K1.TP,\n" +
            "        K1.BATTERY,\n" +
            "        K1.BatterySupplier,\n" +
            "        K1.FrontCamera,\n" +
            "        K1.FrontCameraSupplier,\n" +
            "        K1.BackCamera,\n" +
            "        K1.BackCameraSupplier,\n" +
            "        K2.weight,\n" +
            "        K3.IMEIWriteTime,\n" +
            "        K3.BoxTime,\n" +
            "        K3.PackTime,\n" +
            "        K3.EncryptTime,\n" +
            "        k1.mname,\n" +
            "        K1.FAN,\n" +
            "        K1.OBD,\n" +
            "        K1.BATTERYCOVER,\n" +
            "        K1.FRONTCASE,\n" +
            "        K1.PLATELET\n" +
            "   from keyparts k1, keypartweight k2, keyparttime k3\n" +
            "  where k1.rcard = k2.rcard\n" +
            "    and k1.rcard = k3.rcard\n" +
            " )\n" +
            "     select\n" +
            "     count(*)\n" +
            "  from keypartdata t1, tblmo2imei t2 ,tblmo t3,tblcarton2rcard t4\n" +
            " where t1.rcard = t2.tsn\n" +
            " and t2.mocode = t3.mocode\n" +
            " and t1.rcard = t4.rcard  \n" +
            " \n")
    int getCommonReportMeiZuVOCount(Map<String,Object> map);

}