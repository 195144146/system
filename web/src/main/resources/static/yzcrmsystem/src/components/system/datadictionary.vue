<template>
  <div style="position: relative">
    <Modal
      v-model="addDataDictionary"
      @on-ok="saveDataDictionary"
      @on-cancel="closeAddDataDictionary"
      ok-text="保存"
      cancel-text="取消"
      title="新增数据字典项">
      <Form ref="datadictionaryEntity" :model="datadictionaryEntity" :label-width="80">
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="category" label="种类名称">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.category"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemCode" label="项目代码">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.code"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="值">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.interpretation"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="特殊值1">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.special_1"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="特殊值2">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.special_2"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="特殊值3">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.special_3"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="备注">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.remark"></Input>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Modal>
    <Modal
      v-model="alterDataDictionarybox"
      @on-ok="modifyDataDictionary"
      @on-cancel="closealterDataDictionary"
      ok-text="保存"
      cancel-text="取消"
      title="修改数据字典项">
      <Form ref="alterdatadictionaryEntity" :model="alterdatadictionaryEntity" :label-width="80">
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="category" label="种类名称">
              <Input type="text" v-model="alterdatadictionaryEntity.category"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemCode" label="项目代码">
              <Input type="text" v-model="alterdatadictionaryEntity.code"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="值">
              <Input type="text" v-model="alterdatadictionaryEntity.interpretation"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="特殊值1">
              <Input type="text" v-model="alterdatadictionaryEntity.special_1"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="特殊值2">
              <Input type="text" v-model="alterdatadictionaryEntity.special_2"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="特殊值3">
              <Input type="text" v-model="alterdatadictionaryEntity.special_3"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="备注">
              <Input type="text" v-model="alterdatadictionaryEntity.remark"></Input>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Modal>
    <Layout class="searchBox">
      <Form ref="searchinfo" :model="searchinfo" :label-width="80">
        <Row :gutter="16" type="flex" justify="center" align="middle" class="row-line">
          <Col span="4">
            <FormItem prop="category" label="种类名称：">
              <Input type="text" v-model="searchinfo.category"></Input>
            </FormItem>
          </Col>
          <Col span="4">
            <FormItem prop="itemCode" label="项目代码：">
              <Input type="text" v-model="searchinfo.code"></Input>
            </FormItem>
          </Col>
          <Col span="4">
            <FormItem prop="itemName" label="项目值：">
              <Input type="text" v-model="searchinfo.interpretation"></Input>
            </FormItem>
          </Col>
          <Col span="2" >
            <Form-item>
              <Button type="primary" v-on:click="queryDataDictionary()">查询</Button>
            </Form-item>
          </Col>
        </Row>
      </Form>
    </Layout>
    <Layout style="margin-top: 20px;">
      <Row type="flex" justify="start" align="middle" class="row-line">
        <Col span="2">数据字典列表</Col>
        <Col span="2" offset="20"><span @click="showAddDataDictionary()"> <Icon type="ios-plus" size="24" color="#25e634" ></Icon> </span></Col>
      </Row>
      <Table :columns="columns" :data="datadictionaryinfo"></Table>
    </Layout>
    <Spin fix v-if="spinShow">
      加载中...
      <spinner></spinner>
    </Spin>
  </div>
</template>

<script>

import Spinner from '../common/Spinner'

export default {
  components: {Spinner},
  name: 'dataDictionary',
  data () {
    return {
      spinShow: true,
      addDataDictionary: false,
      alterDataDictionarybox: false,
      searchinfo: {
        category: null,
        code: null,
        interpretation: null,
        remark: null
      },
      columns: [
        {
          title: '种类名称',
          key: 'category'
        }, {
          title: '项目代码',
          key: 'code'
        }, {
          title: '值',
          key: 'interpretation'
        }, {
          title: '特殊值1',
          key: 'special_1'
        }, {
          title: '特殊值2',
          key: 'special_2'
        }, {
          title: '特殊值3',
          key: 'special_3'
        }, {
          title: '备注',
          key: 'remark'
        }, {
          title: '操作',
          key: 'action',
          width: 150,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.alterDataDictionarybox = true
                    this.alterdatadictionaryEntity.id = params.row.id
                    this.alterdatadictionaryEntity.category = params.row.category
                    this.alterdatadictionaryEntity.code = params.row.code
                    this.alterdatadictionaryEntity.interpretation = params.row.interpretation
                    this.alterdatadictionaryEntity.special_1 = params.row.special_1
                    this.alterdatadictionaryEntity.special_2 = params.row.special_2
                    this.alterdatadictionaryEntity.special_3 = params.row.special_3
                    this.alterdatadictionaryEntity.remark = params.row.remark
                  }
                }
              }, '编辑'),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.removeDataDictionary(params.row.id)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      datadictionaryinfo: [],
      ss: {
        body: {}
      },
      datadictionaryEntity: {
        category: null,
        code: null,
        interpretation: null,
        special_1: null,
        special_2: null,
        special_3: null,
        remark: null
      },
      delId: {
        id: null
      },
      alterdatadictionaryEntity: {
        id: null,
        category: null,
        code: null,
        interpretation: null,
        special_1: null,
        special_2: null,
        special_3: null,
        remark: null
      }
    }
  },
  methods: {
    queryDataDictionary () {
      if (!this.spinShow) {
        this.spinShow = true
      }
      this.$http.post('/api/datadictionary/getDataDictionaryList', this.searchinfo, this.ss).then(response => {
        this.datadictionaryinfo = response.body.info
      }, response => {
        // console.info(response.body)
      })
      this.spinShow = false
    },
    showAddDataDictionary () {
      this.addDataDictionary = true
    },
    saveDataDictionary () {
      this.spinShow = true
      this.$http.post('/api/datadictionary/addDataDictionary', this.datadictionaryEntity, this.ss).then(response => {
        // console.info(response)
        if (response.ok) {
          this.queryDataDictionary()
          // this.datadictionaryEntity.forEach((K) => {
          //   this.datadictionaryEntity[K] = null
          // })
          this.$Message.info('新增成功')
        } else {
          this.$Message.info('新增失败')
        }
      }, response => {
        // console.info(response)
        if (response.ok) {
          this.queryDataDictionary()
          // this.datadictionaryEntity.forEach((K) => {
          //   this.datadictionaryEntity[K] = null
          // })
          this.$Message.info('新增成功')
        } else {
          this.$Message.info('新增失败')
        }
      })
      this.spinShow = false
    },
    closeAddDataDictionary () {
      this.$Message.info('取消新增')
    },
    removeDataDictionary (id) {
      this.spinShow = true
      this.delId.id = id
      console.info(this.delId.id)
      this.$http.post('/api/datadictionary/removeDataDictionaryById', this.delId, this.ss).then(response => {
        if (response.ok) {
          this.queryDataDictionary()
          this.$Message.info('删除成功')
        } else {
          this.$Message.info('删除失败')
        }
      }, response => {
        if (response.ok) {
          this.queryDataDictionary()
          this.$Message.info('删除成功')
        } else {
          this.$Message.info('删除失败')
        }
      })
      this.spinShow = false
      // console.log(this.spinShow)
    },
    modifyDataDictionary () {
      this.spinShow = true
      // console.info(this.alterdatadictionaryEntity)
      this.$http.post('/api/datadictionary/alterDataDictionaryById', this.alterdatadictionaryEntity, this.ss).then(response => {
        if (response.ok) {
          this.queryDataDictionary()
          // this.datadictionaryEntity.forEach((K) => {
          //   this.datadictionaryEntity[K] = null
          // })
          this.$Message.info('编辑成功')
        } else {
          this.$Message.info('编辑失败')
        }
        // console.info(response)
      }, response => {
        // console.info(response)
        if (response.ok) {
          this.queryDataDictionary()
          this.$Message.info('编辑成功')
        } else {
          this.$Message.info('编辑失败')
        }
      })
      this.spinShow = false
    },
    closealterDataDictionary () {
      this.$Message.info('取消编辑')
    }
  },
  mounted: function () {
    this.queryDataDictionary()
    this.spinShow = false
  }
}
</script>
<style scoped>
.searchBox{
  /*border-bottom: 1px #dddee1 solid;*/
  width: 100%;
}
.margintop24{
  margin-top: 24px;
}
.ivu-form-item {
  margin-bottom: 0px;
  vertical-align: top;
  zoom: 1;
}
  .row-line{
    height: 60px;
  }
  .row-line40{
    height: 40px;
  }
.demo-spin-icon-load{
  animation: ani-demo-spin 1s linear infinite;
}
@keyframes ani-demo-spin {
  from { transform: rotate(0deg);}
  50%  { transform: rotate(180deg);}
  to   { transform: rotate(360deg);}
}
.demo-spin-col{
  height: 100px;
  position: relative;
  border: 1px solid #eee;
}
</style>
