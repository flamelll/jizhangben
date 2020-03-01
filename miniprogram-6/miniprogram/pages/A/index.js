// pages/A/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    date:'2020-01-01',
    money:'',
    type:'支出',
    type1: [
      { name: '收入', value: '收入' },
      { name: '支出', value: '支出', checked: 'true' },
    ],
    style:'',
    error:'',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  // tally: function(){
  //   console.log(this.data);


  // },
  tally: function () {
    // 判断是否为空
    // if(!this.data.date){
    //   this.setData({
    //     error:"日期不能为空"
    //   });
    //   return;
    // }
    if (!this.data.money) {
      this.setData({
        error: "金额不能为空"
      });
      return;
    }
    // if (!this.data.type) {
    //   this.setData({
    //     error: "类型不能为空"
    //   });
    //   return;
    // }
    if (!this.data.style) {
      this.setData({
        error: "说明不能为空"
      });
      return;
    }
    var that=this;
    wx.request({
      url: 'http://localhost:8080/Tally/WXServletTally',
      data: {
        index:that.data.index,
        date: this.data.date,
        money: this.data.money,
        type: this.data.type,
        style: this.data.style
      },
      method: 'POST',
      header: {
        //'content-type': 'application/json' // 默认值
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data);
        wx.showToast({
          title: '记账成功！',
        })
        // 在一开始用户记账失败产生错误信息后，再次记账成功的话，置错误信息为空
        that.setData({
          error:""
        })
      },
      fail: function (res) {
        console.log(".....fail.....");
        console.log(res);
        // that.setData({
        //   error:res.data.msg
        // });
      }
    })
  },
  inputChange: function(e){
   var prop = e.currentTarget.dataset.type;
    this.data[prop] = e.detail.value;
  },
  dateChange: function(e){
    this.setData({
      date:e.detail.value
    })
  },
  typeChange: function (e) {
    console.log(e)
    this.setData({
      type:e.detail.value
    })
  }
})