package com.xlkj.okhttpretrofitdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeDataBean {
    @SerializedName("curPage")
    private Integer curPage;
    @SerializedName("datas")
    private List<DatasDTO> datas;
    @SerializedName("offset")
    private Integer offset;
    @SerializedName("over")
    private Boolean over;
    @SerializedName("pageCount")
    private Integer pageCount;
    @SerializedName("size")
    private Integer size;
    @SerializedName("total")
    private Integer total;
    @SerializedName("tags")
    private List<TagsDTO> tags;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public List<DatasDTO> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasDTO> datas) {
        this.datas = datas;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<TagsDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagsDTO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "HomeDataBean{" +
                "curPage=" + curPage +
                ", datas=" + datas +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                ", tags=" + tags +
                '}';
    }

    public static class DatasDTO {
        @SerializedName("adminAdd")
        private Boolean adminAdd;
        @SerializedName("apkLink")
        private String apkLink;
        @SerializedName("audit")
        private Integer audit;
        @SerializedName("author")
        private String author;
        @SerializedName("canEdit")
        private Boolean canEdit;
        @SerializedName("chapterId")
        private Integer chapterId;
        @SerializedName("chapterName")
        private String chapterName;
        @SerializedName("collect")
        private Boolean collect;
        @SerializedName("courseId")
        private Integer courseId;
        @SerializedName("desc")
        private String desc;
        @SerializedName("descMd")
        private String descMd;
        @SerializedName("envelopePic")
        private String envelopePic;
        @SerializedName("fresh")
        private Boolean fresh;
        @SerializedName("host")
        private String host;
        @SerializedName("id")
        private Integer id;
        @SerializedName("isAdminAdd")
        private Boolean isAdminAdd;
        @SerializedName("link")
        private String link;
        @SerializedName("niceDate")
        private String niceDate;
        @SerializedName("niceShareDate")
        private String niceShareDate;
        @SerializedName("origin")
        private String origin;
        @SerializedName("prefix")
        private String prefix;
        @SerializedName("projectLink")
        private String projectLink;
        @SerializedName("publishTime")
        private Long publishTime;
        @SerializedName("realSuperChapterId")
        private Integer realSuperChapterId;
        @SerializedName("selfVisible")
        private Integer selfVisible;
        @SerializedName("shareDate")
        private Long shareDate;
        @SerializedName("shareUser")
        private String shareUser;
        @SerializedName("superChapterId")
        private Integer superChapterId;
        @SerializedName("superChapterName")
        private String superChapterName;
        @SerializedName("tags")
        private List<TagsDTO> tags;
        @SerializedName("title")
        private String title;
        @SerializedName("type")
        private Integer type;
        @SerializedName("userId")
        private Integer userId;
        @SerializedName("visible")
        private Integer visible;
        @SerializedName("zan")
        private Integer zan;

        @Override
        public String toString() {
            return "DatasDTO{" +
                    "adminAdd=" + adminAdd +
                    ", apkLink='" + apkLink + '\'' +
                    ", audit=" + audit +
                    ", author='" + author + '\'' +
                    ", canEdit=" + canEdit +
                    ", chapterId=" + chapterId +
                    ", chapterName='" + chapterName + '\'' +
                    ", collect=" + collect +
                    ", courseId=" + courseId +
                    ", desc='" + desc + '\'' +
                    ", descMd='" + descMd + '\'' +
                    ", envelopePic='" + envelopePic + '\'' +
                    ", fresh=" + fresh +
                    ", host='" + host + '\'' +
                    ", id=" + id +
                    ", isAdminAdd=" + isAdminAdd +
                    ", link='" + link + '\'' +
                    ", niceDate='" + niceDate + '\'' +
                    ", niceShareDate='" + niceShareDate + '\'' +
                    ", origin='" + origin + '\'' +
                    ", prefix='" + prefix + '\'' +
                    ", projectLink='" + projectLink + '\'' +
                    ", publishTime=" + publishTime +
                    ", realSuperChapterId=" + realSuperChapterId +
                    ", selfVisible=" + selfVisible +
                    ", shareDate=" + shareDate +
                    ", shareUser='" + shareUser + '\'' +
                    ", superChapterId=" + superChapterId +
                    ", superChapterName='" + superChapterName + '\'' +
                    ", tags=" + tags +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", userId=" + userId +
                    ", visible=" + visible +
                    ", zan=" + zan +
                    '}';
        }

        public Boolean getAdminAdd() {
            return adminAdd;
        }

        public void setAdminAdd(Boolean adminAdd) {
            this.adminAdd = adminAdd;
        }

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public Integer getAudit() {
            return audit;
        }

        public void setAudit(Integer audit) {
            this.audit = audit;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Boolean getCanEdit() {
            return canEdit;
        }

        public void setCanEdit(Boolean canEdit) {
            this.canEdit = canEdit;
        }

        public Integer getChapterId() {
            return chapterId;
        }

        public void setChapterId(Integer chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public Boolean getCollect() {
            return collect;
        }

        public void setCollect(Boolean collect) {
            this.collect = collect;
        }

        public Integer getCourseId() {
            return courseId;
        }

        public void setCourseId(Integer courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDescMd() {
            return descMd;
        }

        public void setDescMd(String descMd) {
            this.descMd = descMd;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public Boolean getFresh() {
            return fresh;
        }

        public void setFresh(Boolean fresh) {
            this.fresh = fresh;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getIsAdminAdd() {
            return isAdminAdd;
        }

        public void setIsAdminAdd(Boolean isAdminAdd) {
            this.isAdminAdd = isAdminAdd;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getNiceShareDate() {
            return niceShareDate;
        }

        public void setNiceShareDate(String niceShareDate) {
            this.niceShareDate = niceShareDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public Long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(Long publishTime) {
            this.publishTime = publishTime;
        }

        public Integer getRealSuperChapterId() {
            return realSuperChapterId;
        }

        public void setRealSuperChapterId(Integer realSuperChapterId) {
            this.realSuperChapterId = realSuperChapterId;
        }

        public Integer getSelfVisible() {
            return selfVisible;
        }

        public void setSelfVisible(Integer selfVisible) {
            this.selfVisible = selfVisible;
        }

        public Long getShareDate() {
            return shareDate;
        }

        public void setShareDate(Long shareDate) {
            this.shareDate = shareDate;
        }

        public String getShareUser() {
            return shareUser;
        }

        public void setShareUser(String shareUser) {
            this.shareUser = shareUser;
        }

        public Integer getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(Integer superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public List<TagsDTO> getTags() {
            return tags;
        }

        public void setTags(List<TagsDTO> tags) {
            this.tags = tags;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getVisible() {
            return visible;
        }

        public void setVisible(Integer visible) {
            this.visible = visible;
        }

        public Integer getZan() {
            return zan;
        }

        public void setZan(Integer zan) {
            this.zan = zan;
        }
    }


    public static class TagsDTO {
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        @Override
        public String toString() {
            return "TagsDTO{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
