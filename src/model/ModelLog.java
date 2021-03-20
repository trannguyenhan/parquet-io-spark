package model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ModelLog {
	private Date timeCreate;
	private int browserCode;
	private String browserVer;
	private String osName;
	private int osCode;
	private String osVer;
	private long ip;
	private String domain;
	private String path;
	private Date cookieCreate;
	private long guid;
	private int siteId;
	private int cId;
	private String referer;
	private int geographic;
	private int locId;
	private String flashVersion;
	private String jre;
	private String sr;
	private String sc;
	private String category;

	public ModelLog() throws ParseException {
		this(new SimpleDateFormat("dd/MM/yyyy").parse("00/00/00"), 0, "", "", 0, "", 0, "", "",
				new SimpleDateFormat("dd/MM/yyyy").parse("00/00/00"), 0, 0, 0, "", 0, 0, "", "", "", "", "");
	}

	public ModelLog(Date timeCreate, int browserCode, String browserVer, String osName, int osCode, String osVer,
			long ip, String domain, String path, Date cookieCreate, long guid, int siteId, int cId, String referer,
			int geographic, int locId, String flashVersion, String jre, String sr, String sc, String category) {
		setTimeCreate(timeCreate);
		setBrowserCode(browserCode);
		setBrowserVer(browserVer);
		setOsName(osName);
		setOsCode(osCode);
		setOsVer(osVer);
		setIp(ip);
		setDomain(domain);
		setPath(path);
		setCookieCreate(cookieCreate);
		setGuid(guid);
		setSiteId(siteId);
		setcId(cId);
		setReferer(referer);
		setGeographic(geographic);
		setLocId(locId);
		setFlashVersion(flashVersion);
		setJre(jre);
		setSc(sc);
		setSr(sr);
		setCategory(category);
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public int getBrowserCode() {
		return browserCode;
	}

	public void setBrowserCode(int browserCode) {
		this.browserCode = browserCode;
	}

	public String getBrowserVer() {
		return browserVer;
	}

	public void setBrowserVer(String browserVer) {
		this.browserVer = browserVer;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public int getOsCode() {
		return osCode;
	}

	public void setOsCode(int osCode) {
		this.osCode = osCode;
	}

	public String getOsVer() {
		return osVer;
	}

	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}

	public long getIp() {
		return ip;
	}

	public void setIp(long ip) {
		this.ip = ip;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCookieCreate() {
		return cookieCreate;
	}

	public void setCookieCreate(Date cookieCreate) {
		this.cookieCreate = cookieCreate;
	}

	public long getGuid() {
		return guid;
	}

	public void setGuid(long guid) {
		this.guid = guid;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public int getGeographic() {
		return geographic;
	}

	public void setGeographic(int geographic) {
		this.geographic = geographic;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getFlashVersion() {
		return flashVersion;
	}

	public void setFlashVersion(String flashVersion) {
		this.flashVersion = flashVersion;
	}

	public String getJre() {
		return jre;
	}

	public void setJre(String jre) {
		this.jre = jre;
	}

	public String getSr() {
		return sr;
	}

	public void setSr(String sr) {
		this.sr = sr;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return timeCreate.toString() + " " + ip + " " + osName;
	}
}
