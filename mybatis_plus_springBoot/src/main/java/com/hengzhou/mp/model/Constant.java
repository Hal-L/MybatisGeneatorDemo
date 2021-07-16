package com.hengzhou.mp.model;

// import com.aliyun.shrek.util.Enums.PlayTypeEnum;
// import org.apache.commons.collections.CollectionUtils;

/**
 * Created by muming on 16/5/31.
 */
public class Constant {

    // private static ConfPropHelper confPropHelper=ConfPropHelper.getInstance();

    /**
     * 平台类型
     */

    public static final String DAHUA 	= "DAHUA" 	;
    public static final String ONVIF 	= "ONVIF" 	;
    public static final String GB28181 	= "GB28181" ;
    public static final String FILE 	= "FILE" 	;
    public static final String RTSP 	= "RTSP" 	;
    public static final String RTMP 	= "RTMP" 	;
    public static final String HTTP 	= "HTTP" 	;
    public static final String OTHER 	= "OTHER" 	;
    public static final String RTMP_HJY = "RTMP_HJY";
    public static final String RTMP_SER = "RTMP_SER";
    public static final String DAHUA_VCLOUD_1 = "DAHUA_VCLOUD_1";

    public static final String UNDERLINE="_";
    public static final String SYMBOL="@";

    public static final int MASTER_TIMEOUT_DURATION = 300; // seconds
    public static final int MASTER_SCHEDULE_INTERVAL = 30; // seconds
    public static final int MACHINE_TIMEOUT_DURATION = 90; // seconds
    public static final int TOPOLOGY_CACHE_EXPIRE_DURATION = 10 * 60; // seconds

    public static final int GROUP_NAME_MAX_LENGTH = 128;
    public static final int GROUP_DESC_MAX_LENGTH = 256;

    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final int ERROR_CODE_RESOURCE_NOT_FOUND = 1;
    public static final int ERROR_CODE_RESOURCE_ALREADY_EXIST = 2;
    public static final int ERROR_CODE_INVALID_OPERATION = 3;
    public static final int ERROR_CODE_INTERNAL_ERROR = 4;

    public static final int HTTP_SUCCESS = 200;

    public static final String JOB_CONF_SHARD_ID = "shardId";
    public static final String JOB_CONF_RTP_PROTOCOL = "rtpProtocol";
    public static final String JOB_CONF_OUTPUT_FORMAT = "outputFormat";
    public static final String JOB_CONF_CHANGE_CAMERA = "changeCamera";
    public static final String JOB_CONF_IS_RTMP = "isRtmp";
    public static final String JOB_CONF_SCALE = "scale";
    //add by wubin 2019-05-14
    public static final String JOB_CONF_ROCKETMQ_STARTTIME = "rocketmqStartTime";
    public static final String JOB_CONF_ROCKETMQ_ENDTIME = "rocketmqEndTime";

    //配置每台机器工作的路数
    public static final Integer ROAD_NUM = 16;


    public static String SECURITY_KEY_UNIT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    //可选配置
    public static final String TASK_CLASSNAME = "shrek.task.classname";
    public static final String TASK_TYPE = "taskType";
    //框架使用
    static public final String MASTER_ROLE = "MASTER";
    static public final String WORKER_ROLE = "WORKER";
    public static final String SLAVE_ROLE = "SLAVE";
    public static final String MACHINE_HEARTBEAT_INTERVAL_IN_SEC = "shrek.machine.heartbeat.interval";
    public static final String MAX_SERVICE_THREAD_SIZE = "shrek.max.com.example.service.thread.size";
    public static final String MIN_SERVICE_THREAD_SIZE = "shrek.min.com.example.service.thread.size";
    public static final long DEFAULT_MACHINE_HEARTBEAT_INTERVAL_IN_SEC = 60L;
    public static final String LOG_PREFIX_FATAL = "[FATAL]";
    public static final String WORKER_CAPACITY = "worker.capacity";

    /**
     * GB28181
     */
    public static final String ACCESS_ID = "datahub.access.id";
    public static final String ACCESS_KEY = "datahub.access.key";
    public static final String DATAHUB_ENDPOINT = "datahub.endpoint";
    public static final String DATA_COLUMN_NAME = "data";
    public static final String REPORT_INTERVAL_MS = "report.interval.ms";
    public static final String COMMIT_TIMEOUT_MS = "commit.timeout.ms";
    public static final String COMMIT_MAX_SIZE = "commit.max.size";
    public static final String DEFAULT_ACCESS_ID = "default.access.id";
    public static final String DEFAULT_ACCESS_KEY = "default.access.key";
    public static final String DEFAULT_DATAHUB_ENDPOINT = "default.datahub.endpoint";
    public static final String CAMERA_ID = "cameraId";
    public static final String LISTEN_TIMEOUT_MS = "listen.timeout.ms";
    public static final String RTP_BUFFER_SIZE = "rtp.buffer.size";
    public static final String RTP_READER_QUEUE_CAPACITY = "rtp.reader.queue.capacity";
    public static final String UPDATE_MONITOR_INTERVAL = "update.monitor.interval";

    /**
     * 请求头key
     */
    public static final String CONTENT_TYPE="application/json;";

    /**
     * 鉴权token的key
     */
    public static final String AUTH_TOKEN="Auth-Token";

    /**
     * 返回前端字符集类型
     */
    public static final String CHARACTER_SET="charset=utf-8";

    /**
     * 流媒体协议类型列表
     */
    // public static List<String> STREAM_MEDIA_PROTOCOL = new ArrayList<>();
    // static {
    //     STREAM_MEDIA_PROTOCOL.add(PlayTypeEnum.PLAY_TYPE_HLS.getCode());
    //     STREAM_MEDIA_PROTOCOL.add(PlayTypeEnum.PLAY_TYPE_FLV.getCode());
    //     STREAM_MEDIA_PROTOCOL.add(PlayTypeEnum.PLAY_TYPE_RTMP.getCode());
    //     STREAM_MEDIA_PROTOCOL.add(PlayTypeEnum.PLAY_TYPE_RTSP.getCode());
    // }

    /**
     * 定时检测摄像头是否在线默认间隔多长时间执行一次 10分钟，单位秒
     */
    public static final Long CYCLE_TIME_DEFAULT = 10*60*1000L;

    /**
     * 视频码流为h264
     */
    public static final String AGREEMENT_TYPE_H264="H264";

    /**
     * 视频码流为h265
     */
    public static final String AGREEMENT_TYPE_H265="H265";

    /**
     * token失效时间,默认30分钟
     */
    // public static final int TOKEN_TIMEOUT=confPropHelper.getInt("token.timeout",1800);
    //
    // public interface RocketMQConf{
    //     String IMAGE_PUSH_NAME_SERVICE = confPropHelper.getString("image.push.name-server", "47.110.37.78:9876");
    //     String IMAGE_PUSH_GROUP = confPropHelper.getString("image.push.group", "camera_stream_image");
    // }

}
