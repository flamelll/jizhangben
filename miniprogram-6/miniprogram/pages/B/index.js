// pages/B/index.js
const app = getApp();
var wxCharts = require('../../../utils/wxcharts.js');
var pieChart = null;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    date:'',
    money:'',
    type:'',
    style:'',
    ty:[{}],
    smoney:0,
    zmoney:0,

  },
  touchHandler: function (e) {
    console.log(pieChart.getCurrentDataIndex(e));
  },     
  onLoad: function (option) {
    var that = this;
    var s = 0;
    var z = 0;
    wx.request({
      url: 'http://localhost:8080/Tally/WXServletShow',
      data: {
        username: '刘子煜',
        password: '123'
      },
      method: 'POST',
      header: {
        //'content-type': 'application/json' // 默认值
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data);
        var ty1 = res.data.data;
        that.setData({
          ty: ty1

        });
        // console.log(ty[0].date);
        // var s=0;
        // var z=0;

        for (let i = 0; i < ty1.length; i++) {
          if (ty1[i].type == '收入') {
            s += parseInt(ty1[i].money)
          }
          else {
            z += parseInt(ty1[i].money)
          }
        }
        console.log(s)
        console.log(z)
        that.setData({
          zmoney:z,
          smoney:s
        })


        var windowWidth = 320;
        try {
          var res = wx.getSystemInfoSync();
          windowWidth = res.windowWidth;
        } catch (option) {
          console.error('getSystemInfoSync failed!');
        }
        pieChart = new wxCharts({
          animation: true,
          canvasId: 'pieCanvas',
          type: 'pie',
          series: [{
            name: '总收入',
            data: s,
          }, {
            name: '总支出',
            data: z,
          }],
          width: windowWidth,
          height: 300,
          dataLabel: true,
        });
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
    console.log(option.query)
    const eventChannel = this.getOpenerEventChannel()
    eventChannel.emit('acceptDataFromOpenedPage', { data: 'test' });
    eventChannel.emit('someEvent', { data: 'test' });
    // 监听acceptDataFromOpenerPage事件，获取上一页面通过eventChannel传送到当前页面的数据
    eventChannel.on('acceptDataFromOpenerPage', function (data) {
      console.log(data)
    })
    
  },
  delete: function(e){
    console.log(e)
  },

  /**
   * 显示删除按钮
   */
  showDeleteButton: function (e) {
    let productIndex = e.currentTarget.dataset.productindex
    this.setXmove(productIndex, -65)
  },

  /**
   * 隐藏删除按钮
   */
  hideDeleteButton: function (e) {
    let productIndex = e.currentTarget.dataset.productindex

    this.setXmove(productIndex, 0)
  },

  /**
   * 设置movable-view位移
   */
  setXmove: function (productIndex, xmove) {
    let ty = this.data.ty
    ty[productIndex].xmove = xmove

    this.setData({
      ty: ty
    })
  },

  /**
   * 处理movable-view移动事件
   */
  handleMovableChange: function (e) {
    if (e.detail.source === 'friction') {
      if (e.detail.x < -30) {
        this.showDeleteButton(e)
      } else {
        this.hideDeleteButton(e)
      }
    } else if (e.detail.source === 'out-of-bounds' && e.detail.x === 0) {
      this.hideDeleteButton(e)
    }
  },

  /**
   * 处理touchstart事件
   */
  handleTouchStart(e) {
    this.startX = e.touches[0].pageX
  },

  /**
   * 处理touchend事件
   */
  handleTouchEnd(e) {
    if (e.changedTouches[0].pageX < this.startX && e.changedTouches[0].pageX - this.startX <= -30) {
      this.showDeleteButton(e)
    } else if (e.changedTouches[0].pageX > this.startX && e.changedTouches[0].pageX - this.startX < 30) {
      this.showDeleteButton(e)
    } else {
      this.hideDeleteButton(e)
    }
  },

  /**
   * 删除产品
   */
  handleDeleteProduct: function ({ currentTarget: { dataset: { date ,money ,type,style} } }) {
    let ty = this.data.ty
    let productIndex = ty.findIndex(item => item.date === date)

    ty.splice(productIndex, 1)

    this.setData({
      ty
    })
    if (ty[productIndex]) {
      this.setXmove(productIndex, 0)
    }
    console.log({ currentTarget: { dataset: { date, money, type, style} } })
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Tally/WXServletDelete',
      data: {
        index: that.data.index,
        date: { currentTarget: { dataset: { date, money, type, style } } }.currentTarget.dataset.date,
        money: { currentTarget: { dataset: { date, money, type, style } } }.currentTarget.dataset.money,
        type: { currentTarget: { dataset: { date, money, type, style } } }.currentTarget.dataset.type,
        style: { currentTarget: { dataset: { date, money, type, style } } }.currentTarget.dataset.style
      },
      method: 'POST',
      header: {
        //'content-type': 'application/json' // 默认值
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data);
        wx.showToast({
          title: '删除成功！',
        })
        that.setData({
          error: ""
        })
      },
      fail: function (res) {
        console.log(".....fail.....");
        // that.setData({
        //   error: res.data.msg
        // });
      }
    })
  },
})